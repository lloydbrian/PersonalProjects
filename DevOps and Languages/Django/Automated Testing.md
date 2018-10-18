# Installing and Using Coverage for Testing
## Install Packages
```
$ pip install coverage
$ pip install django-nose
```

## Configure Django Settings
```
Edit common.py and add django-nose

INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',
    'accounts',
    'courses',
    'flashcards',
    'rest_framework',
    'corsheaders',
    'django_nose',
]

Add these lines after the TEMPLATES line

TEST_RUNNER = 'django_nose.NoseTestSuiteRunner'
NOSE_ARGS = [
    '--with-coverage',
    '--cover-package=accounts,courses,flashcards',
]

```

### Run and Review the tabular results
```
$ python manage.py test
```
