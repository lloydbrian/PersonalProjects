# All About Python (Advanced)

# REST framework
```

>>> from flashcards.models import FlashCard
>>> from flashcards.api.serializers import FlashCardSerializer
>>> f1 = FlashCard.objects.first()
>>> drf_serializer = FlashCardSerializer(f1)
>>> drf_serializer
FlashCardSerializer(<FlashCard: the front side data>):
    front = CharField(max_length=255)
    back = CharField()
>>> drf_serializer.data
{'front': 'the front side data', 'back': 'the back side data'}

>>> from rest_framework.renderers import JSONRenderer
>>> drf_json = JSONRenderer().render(drf_serializer.data)
>>> drf_json
b'{"front":"the front side data","back":"the back side data"}'
>>> type(drf_json)
<class 'bytes'>
>>>
>>> import json
>>> drf_serializer.data
{'front': 'the front side data', 'back': 'the back side data'}
>>> json.dumps(drf_serializer.data)
'{"front": "the front side data", "back": "the back side data"}'
>>> type(json.dumps(drf_serializer.data))
<class 'str'>

>>>
>>> from flashcards.api.serializers import FlashCardSerializer
>>> from flashcards.models import FlashCard
>>> current_flashcards_in_database = FlashCard.objects.all()
>>> current_flashcards_in_database
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>]>
>>> current_flashcards_in_database.all()
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>]>
>>> current_flashcards_in_database.count()
2
>>> new_flashcard_serializer = FlashCardSerializer(data={'front': 'a new front', 'back': 'a new back'})
>>> new_flashcard_serializer.is_valid()
True
>>> new_flashcard_serializer.validated_data
OrderedDict([('front', 'a new front'), ('back', 'a new back')])
>>> new_flashcard_serializer.save()
<FlashCard: a new front>
>>>
>>> FlashCard.objects.all()
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>]>
>>> FlashCard.objects.all().count()
>>> new_card = new_flashcard_serializer.save()
>>> new_card
<FlashCard: a new front>
>>> new_card.save()
>>> FlashCard.objects.all()
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>, <FlashCard: a new front>]>
>>> FlashCard.objects.all().count()
3

Pthon 3.6.6 (v3.6.6:4cf1f54eb7, Jun 26 2018, 19:50:54)
[GCC 4.2.1 Compatible Apple LLVM 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
(InteractiveConsole)
>>> from flashcards.models import FlashCard
>>> from flashcards.api.serializers import FlashCardSerializer
>>> a_new_card = {'front': 'the front side', 'back': 'the back side'}
>>> flashcard_serializer = FlashCardSerializer(data=a_new_card)
>>> flashcard_serializer.is_valid()
True
>>> FlashCard.objects.all()
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>, <FlashCard: a new front>]>
>>> FlashCard.objects.count()
3
>>> flashcard_serializer.save()
<FlashCard: the front side>
>>> FlashCard.objects.all()
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>, <FlashCard: a new front>, <FlashCard: the front side>]>
>>> from flashcards.models import FlashCard
>>> FlashCard.objects.all()
<QuerySet [<FlashCard: the front side data>, <FlashCard: another card front>, <FlashCard: a new front>, <FlashCard: the front side>]>
>>> FlashCard.objects.count()
4

```

# Serializer Basic views

In the views file
```
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.renderers import JSONRenderer
from rest_framework.parsers import JSONParser
from snippets.models import Snippet
from snippets.serializers import SnippetSerializer

```

In the seriliazer  file
```
class SnippetSerializer(serializers.ModelSerializer):
    class Meta:
        model = Snippet
        fields = ('id', 'title', 'code', 'linenos', 'language', 'style')
```

In the views file (from clients that won't have a CSRF token we need to mark the view as csrf_exempt)
```
@csrf_exempt
def snippet_list(request):
    """
    List all code snippets, or create a new snippet.
    """
    if request.method == 'GET':
        snippets = Snippet.objects.all()
        serializer = SnippetSerializer(snippets, many=True)
        return JsonResponse(serializer.data, safe=False)

    elif request.method == 'POST':
        data = JSONParser().parse(request)
        serializer = SnippetSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

@csrf_exempt
def snippet_detail(request, pk):
    """
    Retrieve, update or delete a code snippet.
    """
    try:
        snippet = Snippet.objects.get(pk=pk)
    except Snippet.DoesNotExist:
        return HttpResponse(status=404)

    if request.method == 'GET':
        serializer = SnippetSerializer(snippet)
        return JsonResponse(serializer.data)

    elif request.method == 'PUT':
        data = JSONParser().parse(request)
        serializer = SnippetSerializer(snippet, data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data)
        return JsonResponse(serializer.errors, status=400)

    elif request.method == 'DELETE':
        snippet.delete()
        return HttpResponse(status=204)
```

In the urls file
```
from django.urls import path
from snippets import views

urlpatterns = [
    path('snippets/', views.snippet_list),
    path('snippets/<int:pk>/', views.snippet_detail),
]
```

Update the root urlconfig to route it to the snippets.url
```
from django.urls import path, include

urlpatterns = [
    path('', include('snippets.urls')),
]
```
