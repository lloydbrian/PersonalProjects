# All about MacOS
Use brew only on macOS. Brew is not installed by default in MacOS. You will have to install to be able to install packages conveniently. These packages are normally not in the Apple Store.

## Where to install
Official site of brew is in [Homebrew](https://brew.sh/). Quickest way is to execute this command. And you have to be an administrator to successfully execute the installer.

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

## User Shortcut Commands

* Sleep
```
Shift + Control + Power
```
* Logout with confirmation
```
Command + Shift + Q
```
* Force restart your Mac
```
Command + Control + Power Button
```
* Turn off your Mac
```
Command + Option + Control + Power Button
```
* Logout with no confirmation
```
Command + Shift + Option + Q
```


## Package Installer Commands
```
$ brew --help

To update homebrew package:
$ brew update

$ brew install <package/formulae>
$ brew info <package/formulae>

To upgrade all:
$ brew upgrade
$ brew outdated

To show where brew packages are downloaded
$ brew --cache

$ brew list
```
