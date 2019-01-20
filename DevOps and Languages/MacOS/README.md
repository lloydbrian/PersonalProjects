# All about MacOS
Use brew only on macOS. Brew is not installed by default in MacOS. You will have to install to be able to install packages conveniently. These packages are normally not in the Apple Store.

## Where to install
Official site of brew is in [Homebrew](https://brew.sh/). Quickest way is to execute this command. And you have to be an administrator to successfully execute the installer.

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

## User Shortcut Commands

* Lock Screen
```
Command + Control + Q
```
* Sleep
```
Command + Option + Power Button
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

## SCP Commands
```
Copy the file "foobar.txt" from a remote host to the local host
$ scp your_username@remotehost.edu:foobar.txt /some/local/directory

Copy the file "foobar.txt" from the local host to a remote host
$ scp foobar.txt your_username@remotehost.edu:/some/remote/directory

Copy the directory "foo" from the local host to a remote host's directory "bar"
$ scp -r foo your_username@remotehost.edu:/some/remote/directory/bar

Copy the file "foobar.txt" from remote host "rh1.edu" to remote host "rh2.edu"
$ scp your_username@rh1.edu:/some/remote/directory/foobar.txt \
your_username@rh2.edu:/some/remote/directory/

Copying the files "foo.txt" and "bar.txt" from the local host to your home directory on the remote host
$ scp foo.txt bar.txt your_username@remotehost.edu:~

Copy the file "foobar.txt" from the local host to a remote host using port 2264
$ scp -P 2264 foobar.txt your_username@remotehost.edu:/some/remote/directory

Copy multiple files from the remote host to your current directory on the local host
$ scp your_username@remotehost.edu:/some/remote/directory/\{a,b,c\} .
$ scp your_username@remotehost.edu:~/\{foo.txt,bar.txt\} .

```

## Compression Commands
### TAR.GZ
Second up is TAR, an old favorite on Unix/Linux – you add the GZ for the compression – compresses tighter than zip

To compress
```
tar -zcvf archive_name.tar.gz folder_to_compress
```

To extract
```
tar -zxvf archive_name.tar.gz
```

### TAR.BZ2 – Cross Platform
A variation on TAR GZ but with better compression than both tar.gz and zip.

To compress
```
tar -jcvf archive_name.tar.bz2 folder_to_compress
```

To extract
```
tar -jxvf archive_name.tar.bz2
```
