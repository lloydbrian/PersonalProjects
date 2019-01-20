## HttpResponse objects
class HttpResponse[source]
In contrast to HttpRequest objects, which are created automatically by Django, HttpResponse objects are your responsibility. Each view you write is responsible for instantiating, populating, and returning an HttpResponse.

The HttpResponse class lives in the django.http module.

Usage
Passing strings
Typical usage is to pass the contents of the page, as a string, to the HttpResponse constructor:
```
>>> from django.http import HttpResponse
>>> response = HttpResponse("Here's the text of the Web page.")
>>> response = HttpResponse("Text only, please.", content_type="text/plain")
```
But if you want to add content incrementally, you can use response as a file-like object:
```
>>> response = HttpResponse()
>>> response.write("<p>Here's the text of the Web page.</p>")
>>> response.write("<p>Here's another paragraph.</p>")
```
Passing iterators
Finally, you can pass HttpResponse an iterator rather than strings. HttpResponse will consume the iterator immediately, store its content as a string, and discard it. Objects with a close() method such as files and generators are immediately closed.

If you need the response to be streamed from the iterator to the client, you must use the StreamingHttpResponse class instead.

Setting header fields¶
To set or remove a header field in your response, treat it like a dictionary:
```
>>> response = HttpResponse()
>>> response['Age'] = 120
>>> del response['Age']
```
Note that unlike a dictionary, del doesn’t raise KeyError if the header field doesn’t exist.

For setting the Cache-Control and Vary header fields, it is recommended to use the patch_cache_control() and patch_vary_headers() methods from django.utils.cache, since these fields can have multiple, comma-separated values. The “patch” methods ensure that other values, e.g. added by a middleware, are not removed.

HTTP header fields cannot contain newlines. An attempt to set a header field containing a newline character (CR or LF) will raise BadHeaderError

Telling the browser to treat the response as a file attachment¶
To tell the browser to treat the response as a file attachment, use the content_type argument and set the Content-Disposition header. For example, this is how you might return a Microsoft Excel spreadsheet:
```
>>> response = HttpResponse(my_data, content_type='application/vnd.ms-excel')
>>> response['Content-Disposition'] = 'attachment; filename="foo.xls"'
```
There’s nothing Django-specific about the Content-Disposition header, but it’s easy to forget the syntax, so we’ve included it here.


## JsonResponse objects
```
class JsonResponse(data, encoder=DjangoJSONEncoder, safe=True, json_dumps_params=None, **kwargs)[source]
```
An HttpResponse subclass that helps to create a JSON-encoded response. It inherits most behavior from its superclass with a couple differences:

Its default Content-Type header is set to application/json.

The first parameter, data, should be a dict instance. If the safe parameter is set to False (see below) it can be any JSON-serializable object.

The encoder, which defaults to django.core.serializers.json.DjangoJSONEncoder, will be used to serialize the data. See JSON serialization for more details about this serializer.

The safe boolean parameter defaults to True. If it’s set to False, any object can be passed for serialization (otherwise only dict instances are allowed). If safe is True and a non-dict object is passed as the first argument, a TypeError will be raised.

The json_dumps_params parameter is a dictionary of keyword arguments to pass to the json.dumps() call used to generate the response.

Usage
Typical usage could look like:
```
>>> from django.http import JsonResponse
>>> response = JsonResponse({'foo': 'bar'})
>>> response.content
b'{"foo": "bar"}'
```

Serializing non-dictionary objects
In order to serialize objects other than dict you must set the safe parameter to False:
```
>>> response = JsonResponse([1, 2, 3], safe=False)
Without passing safe=False, a TypeError will be raised.
```
Warning

Before the 5th edition of ECMAScript it was possible to poison the JavaScript Array constructor. For this reason, Django does not allow passing non-dict objects to the JsonResponse constructor by default. However, most modern browsers implement EcmaScript 5 which removes this attack vector. Therefore it is possible to disable this security precaution.

Changing the default JSON encoder
If you need to use a different JSON encoder class you can pass the encoder parameter to the constructor method:
```
>>> response = JsonResponse(data, encoder=MyJSONEncoder)
```
