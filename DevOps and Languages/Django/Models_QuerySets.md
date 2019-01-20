When QuerySets are evaluated¶
Internally, a QuerySet can be constructed, filtered, sliced, and generally passed around without actually hitting the database. No database activity actually occurs until you do something to evaluate the queryset.

You can evaluate a QuerySet in the following ways:

Iteration. A QuerySet is iterable, and it executes its database query the first time you iterate over it. For example, this will print the headline of all entries in the database:
```
for e in Entry.objects.all():
    print(e.headline)
```
Note: Don’t use this if all you want to do is determine if at least one result exists. It’s more efficient to use exists().

Slicing. As explained in Limiting QuerySets, a QuerySet can be sliced, using Python’s array-slicing syntax. Slicing an unevaluated QuerySet usually returns another unevaluated QuerySet, but Django will execute the database query if you use the “step” parameter of slice syntax, and will return a list. Slicing a QuerySet that has been evaluated also returns a list.

Also note that even though slicing an unevaluated QuerySet returns another unevaluated QuerySet, modifying it further (e.g., adding more filters, or modifying ordering) is not allowed, since that does not translate well into SQL and it would not have a clear meaning either.

Pickling/Caching. See the following section for details of what is involved when pickling QuerySets. The important thing for the purposes of this section is that the results are read from the database.

repr(). A QuerySet is evaluated when you call repr() on it. This is for convenience in the Python interactive interpreter, so you can immediately see your results when using the API interactively.

len(). A QuerySet is evaluated when you call len() on it. This, as you might expect, returns the length of the result list.

Note: If you only need to determine the number of records in the set (and don’t need the actual objects), it’s much more efficient to handle a count at the database level using SQL’s SELECT COUNT( * ) . Django provides a count() method for precisely this reason.

list(). Force evaluation of a QuerySet by calling list() on it. For example:
```
entry_list = list(Entry.objects.all())
```
bool(). Testing a QuerySet in a boolean context, such as using bool(), or, and or an if statement, will cause the query to be executed. If there is at least one result, the QuerySet is True, otherwise False. For example:
```
if Entry.objects.filter(headline="Test"):
   print("There is at least one Entry with the headline Test")
```
Note: If you only want to determine if at least one result exists (and don’t need the actual objects), it’s more efficient to use exists().


values()
```
values( *fields, **expressions )
```
Returns a QuerySet that returns dictionaries, rather than model instances, when used as an iterable.

Each of those dictionaries represents an object, with the keys corresponding to the attribute names of model objects.

This example compares the dictionaries of values() with the normal model objects:
```
# This list contains a Blog object.
>>> Blog.objects.filter(name__startswith='Beatles')
<QuerySet [<Blog: Beatles Blog>]>

# This list contains a dictionary.
>>> Blog.objects.filter(name__startswith='Beatles').values()
<QuerySet [{'id': 1, 'name': 'Beatles Blog', 'tagline': 'All the latest Beatles news.'}]>
```
The values() method takes optional positional arguments, * fields, which specify field names to which the SELECT should be limited. If you specify the fields, each dictionary will contain only the field keys/values for the fields you specify. If you don’t specify the fields, each dictionary will contain a key and value for every field in the database table.

```
Example:
>>> Blog.objects.values()
<QuerySet [{'id': 1, 'name': 'Beatles Blog', 'tagline': 'All the latest Beatles news.'}]>
>>> Blog.objects.values('id', 'name')
<QuerySet [{'id': 1, 'name': 'Beatles Blog'}]>

The values() method also takes optional keyword arguments, **expressions, which are passed through to annotate():
>>> from django.db.models.functions import Lower
>>> Blog.objects.values(lower_name=Lower('name'))
<QuerySet [{'lower_name': 'beatles blog'}]>

You can use built-in and custom lookups in ordering. For example:
>>> from django.db.models import CharField
>>> from django.db.models.functions import Lower
>>> CharField.register_lookup(Lower)
>>> Blog.objects.values('name__lower')
<QuerySet [{'name__lower': 'beatles blog'}]>
```


There are three possible scenarios here:
```
1. Don't specify related_name
If you don't specify a name, django will create one by default for you.

some_post = Post.objects.get(id=12345)
comments = some_post.comment_set.all()
The default name is the relation's name + _set.

2. Specify a custom value
Usually you want to specify something to make it more natural. For example, related_name="comments".

some_post = Post.objects.get(id=12345)
comments = some_post.comments.all()
3. Prevent the reverse reference from being created
Sometimes you don't want to add the reference to the foreign model, so use related_name="+" to not create it.

some_post = Post.objects.get(id=12345)
comments = some_post.comment_set.all() # <-- error, no way to access directly
related_query_name is basically the same idea, but when using filter() on a queryset:

posts_by_user = Post.objects.filter(comments__user__id=123)
```
