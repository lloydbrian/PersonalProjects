# All About Python
This is a quick guide of the learned Python concepts.

## Where to install
Official site of Python is in [Python](https://www.python.org/).

```
https://www.python.org/downloads/
```


## Key Learned Concepts

* Coding Style. Use [pycodestyle](https://pypi.org/project/pycodestyle/ ). Install using pip.
```
$ pip install pycodestyle
```

* Running a Python code to test
```
Python Shell
pythontutor.com
unittest class
```

# Variables and Multiple Assignment
# Arithmetic Operators
# Placeholder in Strings
```
(mydevenv) Lloyds-MB-Pro:workspace lloydbrian$ python
Python 3.6.6 (v3.6.6:4cf1f54eb7, Jun 26 2018, 19:50:54)
[GCC 4.2.1 Compatible Apple LLVM 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>> name = "%s is 28 years old"
>>> hello = "Kiara"
>>> name%hello
'Kiara is 28 years old'
>>> name%("Tony")
'Tony is 28 years old'
>>> name = "%s %s is the president"
>>> name%("Barack", "Obama")
'Barack Obama is the president'
>>> name = "%s is %d years old"
>>> name%("Tanya", 25)
'Tanya is 25 years old'
>>> test = name%("Tanya", 25)
>>> test
'Tanya is 25 years old'
```

# DataStructures
## Dictionaries
## Tuples (Immutable compared to List that are Mutable)
```
>>> tup1 = ("apples", "oranges", "grapes")
>>> tup1[0]
'apples'
>>> tup
(1, 2, 3)
>>> tup2 = ("chicken", "beef")
>>> tup2
('chicken', 'beef')
>>> tup2[1] = "pork"
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: 'tuple' object does not support item assignment
>>> tup3 = tup1 + tup2
>>> tup3
('apples', 'oranges', 'grapes', 'chicken', 'beef')
```
# Conditional Operators
```
==, >=, <=, !=, >, <
```

# Looping
```
while():
  continue
  pass
  break
```

# Functions and Built-In Functions
```
abs()
bool()
dir(object type) <-- shows the built-in functions that can be used
help(object.function)
eval() <--takes a string and runs it as a python code can be used when calling function names
exec() <-- executes a string as a python code but is for multi-line codes
str(), float(), int() <-- explicit conversions


>>> dir()
['__annotations__', '__builtins__', '__doc__', '__loader__', '__name__', '__package__', '__spec__', 'c']
>>> dir("string")
['__add__', '__class__', '__contains__', '__delattr__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__getitem__', '__getnewargs__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__iter__', '__le__', '__len__', '__lt__', '__mod__', '__mul__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__rmod__', '__rmul__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', 'capitalize', 'casefold', 'center', 'count', 'encode', 'endswith', 'expandtabs', 'find', 'format', 'format_map', 'index', 'isalnum', 'isalpha', 'isdecimal', 'isdigit', 'isidentifier', 'islower', 'isnumeric', 'isprintable', 'isspace', 'istitle', 'isupper', 'join', 'ljust', 'lower', 'lstrip', 'maketrans', 'partition', 'replace', 'rfind', 'rindex', 'rjust', 'rpartition', 'rsplit', 'rstrip', 'split', 'splitlines', 'startswith', 'strip', 'swapcase', 'title', 'translate', 'upper', 'zfill']
>>> dir(1)
['__abs__', '__add__', '__and__', '__bool__', '__ceil__', '__class__', '__delattr__', '__dir__', '__divmod__', '__doc__', '__eq__', '__float__', '__floor__', '__floordiv__', '__format__', '__ge__', '__getattribute__', '__getnewargs__', '__gt__', '__hash__', '__index__', '__init__', '__init_subclass__', '__int__', '__invert__', '__le__', '__lshift__', '__lt__', '__mod__', '__mul__', '__ne__', '__neg__', '__new__', '__or__', '__pos__', '__pow__', '__radd__', '__rand__', '__rdivmod__', '__reduce__', '__reduce_ex__', '__repr__', '__rfloordiv__', '__rlshift__', '__rmod__', '__rmul__', '__ror__', '__round__', '__rpow__', '__rrshift__', '__rshift__', '__rsub__', '__rtruediv__', '__rxor__', '__setattr__', '__sizeof__', '__str__', '__sub__', '__subclasshook__', '__truediv__', '__trunc__', '__xor__', 'bit_length', 'conjugate', 'denominator', 'from_bytes', 'imag', 'numerator', 'real', 'to_bytes']
>>> dir(object)
['__class__', '__delattr__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__']

```

# Object-Oriented Programming
Classes and Objects (instance of the Class)
init method initializes the variables

```
>>> class Person:
...     pass
...
>>> p = Person()
>>> p
<__main__.Person object at 0x1018e4f28>
>>> class Person:
...     def getName(self):
...             print("Lloyd")
...     def getAge(self):
...             print("secret")
...
>>> p = Person()
>>> p.getName()
Lloyd
>>> p.getAge()
secret
>>>
>>> class Person:
...     def __init__(self, name, age):
...             self.name = name
...             self.age = age
...     def getName(self):
...             print("Your name is " + self.name)
...     def getAge(self):
...             print("and your age is" + self.age)
...
>>> p1 = Person()
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: __init__() missing 2 required positional arguments: 'name' and 'age'
>>> p1 = Person("Lloyd", "Secret")
>>> p1.getName()
Your name is Lloyd
>>> p1.getAge()
and your age isSecret
>>>

```

# Inheritance

```
>>> class Parent:
...     def __init__(self):
...             print("This is the parent class")
...     def parentFunc(self):
...             print("This is the parent func")
...
>>> p = Parent()
This is the parent class
>>> p.parentFunc()
This is the parent func
>>> class Child(Parent):
...     def __init__(self):
...             print("This is the child class")
...     def childFunc(self):
...             print("This is the child func")
...
>>> c = Child()
This is the child class
>>> c.childFunc()
This is the child func
>>> c.parentFunc()
This is the parent func
>>>

>>> class Child(Parent):
...     def __init__(self):
...             print("This is the child class")
...     def parentFunc(self):
...             print("Overrided by the child class")
...
>>> c = Child()
This is the child class
>>> dir(c)
['__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', '__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 'parentFunc']
>>> c.parentFunc()
Overrided by the child class
>>>

```

# Input/Output
## Files
```
Python 3.6.6 (v3.6.6:4cf1f54eb7, Jun 26 2018, 19:50:54)
[GCC 4.2.1 Compatible Apple LLVM 6.0 (clang-600.0.57)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>> testFile = open("Test.txt")
>>> testFile.read()
'Hello World. My Name is LLoyd.\n'
>>> testFile.read()
''
>>> position = testFile.tell()
>>> print(position)
31
>>> position = testFile.seek(0,0)
>>> print(position)
0
>>> testFile.read()
'Hello World. My Name is LLoyd.\n'
>>> testFile.tell()
31
>>> testFile.close()
>>> testFile.tell()
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
ValueError: I/O operation on closed file.
>>>

>>> testFile = open("Test.txt", "w")
>>> testFile.write("\nNew line here.")
15
>>> testFile.tell()
15
>>> testFile.read()
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
io.UnsupportedOperation: not readable
>>> testFile.close()
>>> testFile = open("Test.txt")
>>> testFile.read()
'\nNew line here.'
>>> testFile.close()
>>> testFile = open("Test.txt", "a")
>>> testFile.write("\nHello World")
12
>>> testFile.close()
>>> testFile = open("Test.txt")
>>> testFile.read()
'\nNew line here.\nHello World'
>>>

"a+" == editable and readable

```

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
