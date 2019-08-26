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

# Encoding and Decoding in Python 2
unicode.encode() --> bytes
bytes.decode() --> unicode
```
>>> my_unicode = u"Hi \u2119\u01b4\u2602\u210c\xf8\u1f24"
>>> type(my_unicode)
<type 'unicode'>
>>> my_unicode
u'Hi \u2119\u01b4\u2602\u210c\xf8\u1f24'
>>> len(my_unicode)
9
>>> my_utf8 = my_unicode.encode("utf-8")
>>> len(my_utf8)
19
>>> my_utf8
'Hi \xe2\x84\x99\xc6\xb4\xe2\x98\x82\xe2\x84\x8c\xc3\xb8\xe1\xbc\xa4'
>>> my_utf8.decode("utf-8")
u'Hi \u2119\u01b4\u2602\u210c\xf8\u1f24'

>>> my_unicode.encode("ascii", "replace")
'Hi ??????'
>>> my_unicode.encode("ascii", "ignore")
'Hi '
>>> my_unicode.encode("ascii", "xmlcharrefreplace")
'Hi &#8473;&#436;&#9730;&#8460;&#248;&#7972;'
>>>

```

# Encoding and Decoding in Python 3
Python3 will not implicitly change bytes <-> unicode
unicode.encode() --> bytes (example: utf-8)
bytes.decode() --> unicode
```
>>> my_string = "Hi \u2119\u01b4\u2602\u210c\xf8\u1f24"
>>> type(my_string)
<class 'str'>
>>> my_bytes = b"Hello World"
>>> type(my_bytes)
<class 'bytes'>
>>> "Hello " + b"World"
Traceback (most recent call last):
  File "<pyshell#4>", line 1, in <module>
    "Hello " + b"World"
TypeError: must be str, not bytes
>>> "Hello" == b"Hello"
False
>>> d = {"Hello": "world"}
>>> d[b"Hello"]
Traceback (most recent call last):
  File "<pyshell#7>", line 1, in <module>
    d[b"Hello"]
KeyError: b'Hello'
>>>
```

# Encoding and Decoding Pro-Tips
https://nedbatchelder.com/text/unipain.html
Pro-Tip 1. Bytes on the outside, unicode on the inside. Encode/decode at the edges
bytes byte bytes bytes
decode
unicode unicode
unicode unicode
encode
bytes bytes bytes bytes
Pro-Tip 2. Know what you have. Bytes or Unicode. If bytes, what encoding
Pro-Tip 3. Test ȧƈƈḗƞŧḗḓ ŧḗẋŧ ƒǿř ŧḗşŧīƞɠ, ℛℯα∂α♭ℓℯ ♭ʊ☂ η☺т Ѧ$☾ℐℐ, ¡ooʇ ןnɟǝsn sı uʍop-ǝpısdn

# Encoding and Decoding Facts of Life
1. I/O is always bytes
2. Need more than 256 symbols
3. Need both bytes and unicode
4. Can't infer encodings
5. Declared encodings can be wrong


# Strings
```
for pl, sc in zip(players, scores):
    print ("Player :  %s     Score : %d" %(pl, sc))
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
