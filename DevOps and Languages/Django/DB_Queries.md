Most of the time you’ll use all(), get(), filter() and exclude() when you need to look up objects from the database.


For example, to get a QuerySet of blog entries from the year 2006, use filter() like so:

```
Entry.objects.filter(pub_date__year=2006)
```

With the default manager class, it is the same as:
```
Entry.objects.all().filter(pub_date__year=2006)
```

Chaining filters
The result of refining a QuerySet is itself a QuerySet, so it’s possible to chain refinements together. For example:
```
>>> Entry.objects.filter(
...     headline__startswith='What'
... ).exclude(
...     pub_date__gte=datetime.date.today()
... ).filter(
...     pub_date__gte=datetime.date(2005, 1, 30)
... )

```

If you know there is only one object that matches your query, you can use the get() method on a Manager which returns the object directly:
```
>>> one_entry = Entry.objects.get(pk=1)
```

For example, this returns the first 5 objects (LIMIT 5):
```
>>> Entry.objects.all()[:5]
```
This returns the sixth through tenth objects (OFFSET 5 LIMIT 5):
```
>>> Entry.objects.all()[5:10]
```
To retrieve a single object rather than a list (e.g. SELECT foo FROM bar LIMIT 1), use a simple index instead of a slice. For example, this returns the first Entry in the database, after ordering entries alphabetically by headline:
```
>>> Entry.objects.order_by('headline')[0]
```
This is roughly equivalent to:
```
>>> Entry.objects.order_by('headline')[0:1].get()
```
Note, however, that the first of these will raise IndexError while the second will raise DoesNotExist if no objects match the given criteria. See get() for more details.

Case-sensitive containment test. For example:
```
Entry.objects.get(headline__contains='Lennon')
```
Roughly translates to this SQL:
```
SELECT ... WHERE headline LIKE '%Lennon%';
```

That may sound a bit confusing, so hopefully an example will clarify. To select all blogs that contain entries with both “Lennon” in the headline and that were published in 2008 (the same entry satisfying both conditions), we would write:
```
Blog.objects.filter(entry__headline__contains='Lennon', entry__pub_date__year=2008)
```
To select all blogs that contain an entry with “Lennon” in the headline as well as an entry that was published in 2008, we would write:
```
>>> Blog.objects.filter(entry__headline__contains='Lennon').filter(entry__pub_date__year=2008)
```

In the example Blog model, the primary key is the id field, so these three statements are equivalent:
```

>>> Blog.objects.get(id__exact=14) # Explicit form
>>> Blog.objects.get(id=14) # __exact is implied
>>> Blog.objects.get(pk=14) # pk implies id__exact
```
The use of pk isn’t limited to exact queries – any query term can be combined with pk to perform a query on the primary key of a model:
```

# Get blogs entries with id 1, 4 and 7
>>> Blog.objects.filter(pk__in=[1,4,7])
```
```

# Get all blog entries with id > 14
>>> Blog.objects.filter(pk__gt=14)
```
pk lookups also work across joins. For example, these three statements are equivalent:
```
>>> Entry.objects.filter(blog__id__exact=3) # Explicit form
>>> Entry.objects.filter(blog__id=3)        # __exact is implied
>>> Entry.objects.filter(blog__pk=3)        # __pk implies __id__exact
```

Keep this caching behavior in mind, because it may bite you if you don’t use your QuerySets correctly. For example, the following will create two QuerySets, evaluate them, and throw them away:
```
>>> print([e.headline for e in Entry.objects.all()])
>>> print([e.pub_date for e in Entry.objects.all()])
```
That means the same database query will be executed twice, effectively doubling your database load. Also, there’s a possibility the two lists may not include the same database records, because an Entry may have been added or deleted in the split second between the two requests.

To avoid this problem, simply save the QuerySet and reuse it:
```
>>> queryset = Entry.objects.all()
>>> print([p.headline for p in queryset]) # Evaluate the query set.
>>> print([p.pub_date for p in queryset]) # Re-use the cache from the evaluation.
```


A Q object (django.db.models.Q) is an object used to encapsulate a collection of keyword arguments. These keyword arguments are specified as in “Field lookups” above.

For example, this Q object encapsulates a single LIKE query:
```
from django.db.models import Q
Q(question__startswith='What')
```


Q objects can be combined using the & and | operators. When an operator is used on two Q objects, it yields a new Q object.

For example, this statement yields a single Q object that represents the “OR” of two "question__startswith" queries:
```
Q(question__startswith='Who') | Q(question__startswith='What')
```

This is equivalent to the following SQL WHERE clause:
```
WHERE question LIKE 'Who%' OR question LIKE 'What%'
```

You can compose statements of arbitrary complexity by combining Q objects with the & and | operators and use parenthetical grouping. Also, Q objects can be negated using the ~ operator, allowing for combined lookups that combine both a normal query and a negated (NOT) query:
```
Q(question__startswith='Who') | ~Q(pub_date__year=2005)
```

Each lookup function that takes keyword-arguments (e.g. filter(), exclude(), get()) can also be passed one or more Q objects as positional (not-named) arguments. If you provide multiple Q object arguments to a lookup function, the arguments will be “AND”ed together. For example:

```
Poll.objects.get(
    Q(question__startswith='Who'),
    Q(pub_date=date(2005, 5, 2)) | Q(pub_date=date(2005, 5, 6))
)
```

… roughly translates into the SQL:
```
SELECT * from polls WHERE question LIKE 'Who%'
    AND (pub_date = '2005-05-02' OR pub_date = '2005-05-06')

```

Lookup functions can mix the use of Q objects and keyword arguments. All arguments provided to a lookup function (be they keyword arguments or Q objects) are “AND”ed together. However, if a Q object is provided, it must precede the definition of any keyword arguments. For example:

```
Poll.objects.get(
    Q(pub_date=date(2005, 5, 2)) | Q(pub_date=date(2005, 5, 6)),
    question__startswith='Who',
)
```

… would be a valid query, equivalent to the previous example; but:

```
# INVALID QUERY
Poll.objects.get(
    question__startswith='Who',
    Q(pub_date=date(2005, 5, 2)) | Q(pub_date=date(2005, 5, 6))
)
```

… would not be valid.

You can also delete objects in bulk. Every QuerySet has a delete() method, which deletes all members of that QuerySet.

For example, this deletes all Entry objects with a pub_date year of 2005:
```

>>> Entry.objects.filter(pub_date__year=2005).delete()
(5, {'webapp.Entry': 5})
```

Sometimes you want to set a field to a particular value for all the objects in a QuerySet. You can do this with the update() method. For example:
```
# Update all the headlines with pub_date in 2007.
Entry.objects.filter(pub_date__year=2007).update(headline='Everything is the same')
```
You can only set non-relation fields and ForeignKey fields using this method. To update a non-relation field, provide the new value as a constant. To update ForeignKey fields, set the new value to be the new model instance you want to point to. For example:
```

>>> b = Blog.objects.get(pk=1)

# Change every Entry so that it belongs to this Blog.
>>> Entry.objects.all().update(blog=b)
```
The update() method is applied instantly and returns the number of rows matched by the query (which may not be equal to the number of rows updated if some rows already have the new value). The only restriction on the QuerySet being updated is that it can only access one database table: the model’s main table. You can filter based on related fields, but you can only update columns in the model’s main table. Example:
```

>>> b = Blog.objects.get(pk=1)

# Update all the headlines belonging to this Blog.
>>> Entry.objects.select_related().filter(blog=b).update(headline='Everything is the same')
```
Be aware that the update() method is converted directly to an SQL statement. It is a bulk operation for direct updates. It doesn’t run any save() methods on your models, or emit the pre_save or post_save signals (which are a consequence of calling save()), or honor the auto_now field option. If you want to save every item in a QuerySet and make sure that the save() method is called on each instance, you don’t need any special function to handle that. Just loop over them and call save():
```
for item in my_queryset:
    item.save()
```


Forward
If a model has a ForeignKey, instances of that model will have access to the related (foreign) object via a simple attribute of the model.

Example:
```
>>> e = Entry.objects.get(id=2)
>>> e.blog # Returns the related Blog object.
```
You can get and set via a foreign-key attribute. As you may expect, changes to the foreign key aren’t saved to the database until you call save(). Example:
```
>>> e = Entry.objects.get(id=2)
>>> e.blog = some_blog
>>> e.save()
```
If a ForeignKey field has null=True set (i.e., it allows NULL values), you can assign None to remove the relation. Example:
```
>>> e = Entry.objects.get(id=2)
>>> e.blog = None
>>> e.save() # "UPDATE blog_entry SET blog_id = NULL ...;"
```
Forward access to one-to-many relationships is cached the first time the related object is accessed. Subsequent accesses to the foreign key on the same object instance are cached. Example:
```
>>> e = Entry.objects.get(id=2)
>>> print(e.blog)  # Hits the database to retrieve the associated Blog.
>>> print(e.blog)  # Doesn't hit the database; uses cached version.
```
Note that the select_related() QuerySet method recursively prepopulates the cache of all one-to-many relationships ahead of time. Example:
```
>>> e = Entry.objects.select_related().get(id=2)
>>> print(e.blog)  # Doesn't hit the database; uses cached version.
>>> print(e.blog)  # Doesn't hit the database; uses cached version.
```


Following relationships “backward”
If a model has a ForeignKey, instances of the foreign-key model will have access to a Manager that returns all instances of the first model. By default, this Manager is named FOO_set, where FOO is the source model name, lowercased. This Manager returns QuerySets, which can be filtered and manipulated as described in the “Retrieving objects” section above.

Example:
```
>>> b = Blog.objects.get(id=1)
>>> b.entry_set.all() # Returns all Entry objects related to Blog.

# b.entry_set is a Manager that returns QuerySets.
>>> b.entry_set.filter(headline__contains='Lennon')
>>> b.entry_set.count()
```
You can override the FOO_set name by setting the related_name parameter in the ForeignKey definition. For example, if the Entry model was altered to blog = ForeignKey(Blog, on_delete=models.CASCADE, related_name='entries'), the above example code would look like this:
```
>>> b = Blog.objects.get(id=1)
>>> b.entries.all() # Returns all Entry objects related to Blog.

# b.entries is a Manager that returns QuerySets.
>>> b.entries.filter(headline__contains='Lennon')
>>> b.entries.count()
```

Using a custom reverse manager¶
By default the RelatedManager used for reverse relations is a subclass of the default manager for that model. If you would like to specify a different manager for a given query you can use the following syntax:
```
from django.db import models

class Entry(models.Model):
    #...
    objects = models.Manager()  # Default Manager
    entries = EntryManager()    # Custom Manager

b = Blog.objects.get(id=1)
b.entry_set(manager='entries').all()
```
If EntryManager performed default filtering in its get_queryset() method, that filtering would apply to the all() call.

Of course, specifying a custom reverse manager also enables you to call its custom methods:
```
b.entry_set(manager='entries').is_published()
```
