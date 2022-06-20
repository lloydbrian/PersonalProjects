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
pip install pycodestyle
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
<https://nedbatchelder.com/text/unipain.html>
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

>>> print("%(lang)s is fun!" % {"lang":"Python"})
Python is fun!

>>> xy = {"x":0, "y":10}
>>> print("Graph a point at where x={x} and y={y}".format(**xy))
Graph a point at where x=0 and y=10
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


def a_function():
  print("Sample function")

// stub function
def stub_function():
  pass //nothing happens in this function

def sample_function(a, b):
  return a+b

*args // unpacking operator for tuples
**kwargs // unpacking operator for dictionariesd

```

# Comprehensions

## Lists

```
my_dict = [1,2,3,4,5]
y = [2*i for i in my_dict]
print(y)
```

## Dictionaries

```
my_dict = {1:"1", 2:"2", 3:"3"}
print({value:key for key, value in my_dict.items()})
```

## Sets

```
my_dict = [1,2,1,2,3,4,1,1,3,4,5]
my_set = set(my_dict)

OR

my_dict = [1,2,1,2,3,4,1,1,3,4,5]
my_set = {x for x in my_dict}
```

# Exception Handling

else executes if there are no errors
finally always executes

```
try:
  1/0
except ZeroDivisionError:
  print("You cannot divide by zero!")
else:
  print("No errors")
finally:
  print("This will always execute")
```

# Classes

class ClassName(*objects): //object is what the class is based on or inhering from, base class or parent class
  def __init__(self):
    //"""Constructore"""
    pass

if __name__ == "__main__": // only run the code if this code is executed as a stand-alone file, if class is imported, this code will not run
  pass

## SubClasses

class Car(Vehicle):
    """
    The Car class
    """

    def brake(self):
        """
        Override brake method
        """
        return "The car class is breaking slowly!"

if __name__ == "__main__":
    car = Car("yellow", 2, 4, "car")
    car.brake()
    'The car class is breaking slowly!'
    car.drive()
    "I'm driving a yellow car!"

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

handle = open("test.txt", "r")
data = handle.read() // entire file as a string
data = handle.readline() // read one line only
data = handle.readlines() // read all lines and store in a list
print(data)
handle.close()

handle = open("test.txc", "r")
for line in handle
  print(line)

while True:
  data = handle.read(1024)
  print(data)
  if not data:
    break

handle.close()

handle = open("test.pdf", "rb") //read-binary
handle = open("test.txt", "w") //write
handle = open("test.txt", "wb") //write-binary


with open("test.txt") as file_handler
  for line in file_handler:
    print(line)

try:
  file_handler = open("test.txt")
  for line in file_handler:
    print(line)
except IOError:
  print("IOError")
finally:
  file_handler.close()

try:
  with open("test.txt") as file_handler:
    for line in file_handler:
      print(line)
except IOError:
  print("IOError")
```

# Sample Libraries

## Introspection

```
type
dir
help
```

## CSV module

1. reader function
2. DictReader class

```
//Sample
import csv

def csv_reader(file_obj):
    """
    Read a csv file
    """
    reader = csv.reader(file_obj)
    for row in reader:
        print(" ".join(row))

if __name__ == "__main__":
    csv_path = "TB_data_dictionary_2014-02-26.csv"
    with open(csv_path, "r") as f_obj:
        csv_reader(f_obj)

//Another sample with a delimeter. DictReader returns a dictionary
import csv

def csv_dict_reader(file_obj):
    """
    Read a CSV file using csv.DictReader
    """
    reader = csv.DictReader(file_obj, delimiter=',')
    for line in reader:
        print(line["first_name"]),
        print(line["last_name"])

if __name__ == "__main__":
    with open("data.csv") as f_obj:
        csv_dict_reader(f_obj)

// Sample of writing
import csv

def csv_writer(data, path):
    """
    Write data to a CSV file path
    """
    with open(path, "w", newline='') as csv_file:
        writer = csv.writer(csv_file, delimiter=',')
        for line in data:
            writer.writerow(line)

if __name__ == "__main__":
    data = ["first_name,last_name,city".split(","),
            "Tyrese,Hirthe,Strackeport".split(","),
            "Jules,Dicki,Lake Nickolasville".split(","),
            "Dedric,Medhurst,Stiedemannberg".split(",")
            ]
    path = "output.csv"
    csv_writer(data, path)



```

## Config Parser

```
import configparser

def createConfig(path):
    """
    Create a config file
    """
    config = configparser.ConfigParser()
    config.add_section("Settings")
    config.set("Settings", "font", "Courier")
    config.set("Settings", "font_size", "10")
    config.set("Settings", "font_style", "Normal")
    config.set("Settings", "font_info",
               "You are using %(font)s at %(font_size)s pt")

    with open(path, "w") as config_file:
        config.write(config_file)


if __name__ == "__main__":
    path = "settings.ini"
    createConfig(path)

// Clean example with crud operations
import configparser
import os

def create_config(path):
    """
    Create a config file
    """
    config = configparser.ConfigParser()
    config.add_section("Settings")
    config.set("Settings", "font", "Courier")
    config.set("Settings", "font_size", "10")
    config.set("Settings", "font_style", "Normal")
    config.set("Settings", "font_info",
               "You are using %(font)s at %(font_size)s pt")

    with open(path, "w") as config_file:
        config.write(config_file)


def get_config(path):
    """
    Returns the config object
    """
    if not os.path.exists(path):
        create_config(path)

    config = configparser.ConfigParser()
    config.read(path)
    return config


def get_setting(path, section, setting):
    """
    Print out a setting
    """
    config = get_config(path)
    value = config.get(section, setting)
    msg = "{section} {setting} is {value}".format(
        section=section, setting=setting, value=value)
    print(msg)
    return value


def update_setting(path, section, setting, value):
    """
    Update a setting
    """
    config = get_config(path)
    config.set(section, setting, value)
    with open(path, "w") as config_file:
        config.write(config_file)


def delete_setting(path, section, setting):
    """
    Delete a setting
    """
    config = get_config(path)
    config.remove_option(section, setting)
    with open(path, "w") as config_file:
        config.write(config_file)



if __name__ == "__main__":
    path = "settings.ini"
    font = get_setting(path, 'Settings', 'font')
    font_size = get_setting(path, 'Settings', 'font_size')

    update_setting(path, "Settings", "font_size", "12")

    delete_setting(path, "Settings", "font_style")


```

# Logging

```
import logging

# add filemode="w" to overwrite
logging.basicConfig(filename="sample.log", level=logging.INFO)

logging.debug("This is a debug message")
logging.info("Informational message")
logging.error("An error has happened!")
```

```
import logging

logging.basicConfig(filename="sample.log", level=logging.INFO)
log = logging.getLogger("ex")

try:
    raise RuntimeError
except RuntimeError:
    log.exception("Error!")
```

```
// loggers, formatters, handlers
import logging
import otherMod2

def main():
    """
    The main entry point of the application
    """
    logger = logging.getLogger("exampleApp")
    logger.setLevel(logging.INFO)

    # create the logging file handler
    fh = logging.FileHandler("new_snake.log")

    formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    fh.setFormatter(formatter)

    # add handler to logger object
    logger.addHandler(fh)

    logger.info("Program started")
    result = otherMod2.add(7, 8)
    logger.info("Done!")

if __name__ == "__main__":
    main()
```

```
// Customized loggers
// logger.ini

[loggers]
keys=root,exampleApp

[handlers]
keys=fileHandler, consoleHandler

[formatters]
keys=myFormatter

[logger_root]
level=CRITICAL
handlers=consoleHandler

[logger_exampleApp]
level=INFO
handlers=fileHandler
qualname=exampleApp

[handler_consoleHandler]
class=StreamHandler
level=DEBUG
formatter=myFormatter
args=(sys.stdout,)

[handler_fileHandler]
class=FileHandler
formatter=myFormatter
args=("config.log",)

[formatter_myFormatter]
format=%(asctime)s - %(name)s - %(levelname)s - %(message)s
datefmt=

# log_with_config.py
import logging
import logging.config
import otherMod2

def main():
    """
    Based on http://docs.python.org/howto/logging.html#configuring-logging
    """
    logging.config.fileConfig('logging.conf')
    logger = logging.getLogger("exampleApp")

    logger.info("Program started")
    result = otherMod2.add(7, 8)
    logger.info("Done!")

if __name__ == "__main__":
    main()


# log_with_config.py
import logging
import logging.config
import otherMod2

def main():
    """
    Based on http://docs.python.org/howto/logging.html#configuring-logging
    """
    dictLogConfig = {
        "version":1,
        "handlers":{
                    "fileHandler":{
                        "class":"logging.FileHandler",
                        "formatter":"myFormatter",
                        "filename":"config2.log"
                        }
                    },
        "loggers":{
            "exampleApp":{
                "handlers":["fileHandler"],
                "level":"INFO",
                }
            },

        "formatters":{
            "myFormatter":{
                "format":"%(asctime)s - %(name)s - %(levelname)s - %(message)s"
                }
            }
        }

    logging.config.dictConfig(dictLogConfig)

    logger = logging.getLogger("exampleApp")

    logger.info("Program started")
    result = otherMod2.add(7, 8)
    logger.info("Done!")

if __name__ == "__main__":
    main()

```

## OS Module

```
os.name
os.environ
os.chdir()
os.getcwd()
os.getenv()
os.putenv()
os.mkdir()
os.makedirs()
os.remove()
os.rename()
os.rmdir()
os.startfile()
os.walk()
os.path
```

## Email

```
import smtplib

def send_email(host, subject, to_addr, from_addr, body_text):
    """
    Send an email
    """
    BODY = "\r\n".join((
            "From: %s" % from_addr,
            "To: %s" % to_addr,
            "Subject: %s" % subject ,
            "",
            body_text
            ))
    server = smtplib.SMTP(host)
    server.sendmail(from_addr, [to_addr], BODY)
    server.quit()

if __name__ == "__main__":
    host = "mySMTP.server.com"
    subject = "Test email from Python"
    to_addr = "mike@someAddress.org"
    from_addr = "python@mydomain.com"
    body_text = "Python rules them all!"
    send_email(host, subject, to_addr, from_addr, body_text)
```

```
// Config.ini

[smtp]
server = some.server.com
from_addr = python@mydomain.com

import os
import smtplib
import sys

from configparser import ConfigParser

def send_email(subject, body_text, emails):
    """
    Send an email
    """
    base_path = os.path.dirname(os.path.abspath(__file__))
    config_path = os.path.join(base_path, "email.ini")

    if os.path.exists(config_path):
        cfg = ConfigParser()
        cfg.read(config_path)
    else:
        print("Config not found! Exiting!")
        sys.exit(1)

    host = cfg.get("smtp", "server")
    from_addr = cfg.get("smtp", "from_addr")

    BODY = "\r\n".join((
            "From: %s" % from_addr,
            "To: %s" % ', '.join(emails),
            "Subject: %s" % subject ,
            "",
            body_text
            ))
    server = smtplib.SMTP(host)
    server.sendmail(from_addr, emails, BODY)
    server.quit()

if __name__ == "__main__":
    emails = ["mike@someAddress.org", "someone@gmail.com"]
    subject = "Test email from Python"
    body_text = "Python rules them all!"
    send_email(subject, body_text, emails)

```

```
// Email with attachment
import os
import smtplib
import sys

from configparser import ConfigParser
from email import encoders
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email.mime.multipart import MIMEMultipart
from email.utils import formatdate

#----------------------------------------------------------------------
def send_email_with_attachment(subject, body_text, to_emails,
                               cc_emails, bcc_emails, file_to_attach):
    """
    Send an email with an attachment
    """
    base_path = os.path.dirname(os.path.abspath(__file__))
    config_path = os.path.join(base_path, "email.ini")
    header = 'Content-Disposition', 'attachment; filename="%s"' % file_to_attach

    # get the config
    if os.path.exists(config_path):
        cfg = ConfigParser()
        cfg.read(config_path)
    else:
        print("Config not found! Exiting!")
        sys.exit(1)

    # extract server and from_addr from config
    host = cfg.get("smtp", "server")
    from_addr = cfg.get("smtp", "from_addr")

    # create the message
    msg = MIMEMultipart()
    msg["From"] = from_addr
    msg["Subject"] = subject
    msg["Date"] = formatdate(localtime=True)
    if body_text:
        msg.attach( MIMEText(body_text) )

    msg["To"] = ', '.join(to_emails)
    msg["cc"] = ', '.join(cc_emails)

    attachment = MIMEBase('application', "octet-stream")
    try:
        with open(file_to_attach, "rb") as fh:
            data = fh.read()
        attachment.set_payload( data )
        encoders.encode_base64(attachment)
        attachment.add_header(*header)
        msg.attach(attachment)
    except IOError:
        msg = "Error opening attachment file %s" % file_to_attach
        print(msg)
        sys.exit(1)

    emails = to_emails + cc_emails

    server = smtplib.SMTP(host)
    server.sendmail(from_addr, emails, msg.as_string())
    server.quit()

if __name__ == "__main__":
    emails = ["mike@someAddress.org", "nedry@jp.net"]
    cc_emails = ["someone@gmail.com"]
    bcc_emails = ["anonymous@circe.org"]

    subject = "Test email with attachment from Python"
    body_text = "This email contains an attachment!"
    path = "/path/to/some/file"
    send_email_with_attachment(subject, body_text, emails,
                               cc_emails, bcc_emails, path)
```

## SQLite Modules

### Create a Database and Insert Data

SQLite only supports five data types: null, integer, real, text and blob.

```
import sqlite3

conn = sqlite3.connect("mydatabase.db") # or use :memory: to put it in RAM

cursor = conn.cursor()

# create a table
cursor.execute("""CREATE TABLE albums
                  (title text, artist text, release_date text,
                   publisher text, media_type text)
               """)

# insert some data
cursor.execute("""INSERT INTO albums
                  VALUES ('Glow', 'Andy Hunter', '7/24/2012',
                          'Xplore Records', 'MP3')"""
               )

# save data to database
conn.commit()

# insert multiple records using the more secure "?" method
albums = [('Exodus', 'Andy Hunter', '7/9/2002', 'Sparrow Records', 'CD'),
          ('Until We Have Faces', 'Red', '2/1/2011', 'Essential Records', 'CD'),
          ('The End is Where We Begin', 'Thousand Foot Krutch', '4/17/2012', 'TFKmusic', 'CD'),
          ('The Good Life', 'Trip Lee', '4/10/2012', 'Reach Records', 'CD')]
cursor.executemany("INSERT INTO albums VALUES (?,?,?,?,?)", albums)
conn.commit()
```

### Updating and Deleting Records

```
import sqlite3

conn = sqlite3.connect("mydatabase.db")
cursor = conn.cursor()

sql = """
UPDATE albums
SET artist = 'John Doe'
WHERE artist = 'Andy Hunter'
"""
cursor.execute(sql)
conn.commit()

```

...

```
import sqlite3

conn = sqlite3.connect("mydatabase.db")
cursor = conn.cursor()

sql = """
DELETE FROM albums
WHERE artist = 'John Doe'
"""
cursor.execute(sql)
conn.commit()
```

### Basic Queries

```
import sqlite3

conn = sqlite3.connect("mydatabase.db")
#conn.row_factory = sqlite3.Row
cursor = conn.cursor()

sql = "SELECT * FROM albums WHERE artist=?"
cursor.execute(sql, [("Red")])
print(cursor.fetchall())  # or use fetchone()

print("\nHere's a listing of all the records in the table:\n")
for row in cursor.execute("SELECT rowid, * FROM albums ORDER BY artist"):
    print(row)

print("\nResults from a LIKE query:\n")
sql = """
SELECT * FROM albums
WHERE title LIKE 'The%'"""
cursor.execute(sql)
print(cursor.fetchall())
```

## The call function

from the subprocess module used to call another program. Think about forking another program

```
>>> import subprocess
>>> subprocess.call("notepad.exe")
0
>>> code = subprocess.call("notepad.exe")
>>> if code == 0:
        print("Success!")
    else:
        print("Error!")
Success!


```

### Popen class

```
>>> program = "notepad.exe"
>>> process = subprocess.Popen(program)
>>> code = process.wait()
>>> print(code)
0
```

Communicating with the process

```
args = ["ping", "www.yahoo.com"]
process = subprocess.Popen(args, stdout=subprocess.PIPE)

data = process.communicate()
for line in data:
    print(line)
```

## The sys module

```
Samples are:
sys.argv
sys.executable
sys.exit
sys.modules
sys.path
sys.platform
sys.stdin/stdout/stderr
```

### sys.arg

Python list of command line arguments passed to the python script. First arg is the name of the script.

```
>>> import sys
>>> sys.argv
['']
```

### sys.executable

is the absolute path of the Python interpreter

```
>>> import sys
>>> sys.executable
'C:\\Python27\\pythonw.exe'
```

### sys.exit

### sys.path

list of strings that specifies the search path of modules

```
>>> import sys
>>> print(sys.path)
```

### sys.platform

### sys.stdin, stdout, stderr

correspond to the interpreter's standard input, output, and error streams

## The threading module

```
import random
import time

from threading import Thread

class MyThread(Thread):
    """
    A threading example
    """

    def __init__(self, name):
        """Initialize the thread"""
        Thread.__init__(self)
        self.name = name

    def run(self):
        """Run the thread"""
        amount = random.randint(3, 15)
        time.sleep(amount)
        msg = "%s is running" % self.name
        print(msg)

def create_threads():
    """
    Create a group of threads
    """
    for i in range(5):
        name = "Thread #%s" % (i+1)
        my_thread = MyThread(name)
        my_thread.start()

if __name__ == "__main__":
    create_threads()
```

### Thread downloader

```
import os
import urllib.request

from threading import Thread

class DownloadThread(Thread):
    """
    A threading example that can download a file
    """

    def __init__(self, url, name):
        """Initialize the thread"""
        Thread.__init__(self)
        self.name = name
        self.url = url

    def run(self):
        """Run the thread"""
        handle = urllib.request.urlopen(self.url)
        fname = os.path.basename(self.url)
        with open(fname, "wb") as f_handler:
            while True:
                chunk = handle.read(1024)
                if not chunk:
                    break
                f_handler.write(chunk)
        msg = "%s has finished downloading %s!" % (self.name,
                                                   self.url)
        print(msg)

def main(urls):
    """
    Run the program
    """
    for item, url in enumerate(urls):
        name = "Thread %s" % (item+1)
        thread = DownloadThread(url, name)
        thread.start()

if __name__ == "__main__":
    urls = ["http://www.irs.gov/pub/irs-pdf/f1040.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040a.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040ez.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040es.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040sb.pdf"]
    main(urls)
```

### Using queues

FIFO or LILO

```
import os
import threading
import urllib.request

from queue import Queue

class Downloader(threading.Thread):
    """Threaded File Downloader"""

    def __init__(self, queue):
        """Initialize the thread"""
        threading.Thread.__init__(self)
        self.queue = queue

    def run(self):
        """Run the thread"""
        while True:
            # gets the url from the queue
            url = self.queue.get()

            # download the file
            self.download_file(url)

            # send a signal to the queue that the job is done
            self.queue.task_done()

    def download_file(self, url):
        """Download the file"""
        handle = urllib.request.urlopen(url)
        fname = os.path.basename(url)
        with open(fname, "wb") as f:
            while True:
                chunk = handle.read(1024)
                if not chunk: break
                f.write(chunk)

def main(urls):
    """
    Run the program
    """
    queue = Queue()

    # create a thread pool and give them a queue
    for i in range(5):
        t = Downloader(queue)
        t.setDaemon(True)
        t.start()

    # give the queue some data
    for url in urls:
        queue.put(url)

    # wait for the queue to finish
    queue.join()

if __name__ == "__main__":
    urls = ["http://www.irs.gov/pub/irs-pdf/f1040.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040a.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040ez.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040es.pdf",
            "http://www.irs.gov/pub/irs-pdf/f1040sb.pdf"]
    main(urls)
```
