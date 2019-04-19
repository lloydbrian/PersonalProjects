# COMP835: Networking Technologies
## tcpdump


* Lloyd Dagoc
* Spring 2019
* University of New Hampshire

tcpdump on en0 interface with no host or port resolution
unlimited packet and line buffered
```
$ sudo tcpdump -i en0 -nn -s0 -l
```

tcpdump on en0 interface with no host or port resolution
unlimited packet and line buffered
tcp protocol only (can be udp or proto parameter)
```
$ sudo tcpdump -i en0 -nn -s0 -l tcp
```

tcpdump on en0 interface with no host or port resolution
unlimited packet and line buffered
tcp protocol only (can be udp or proto parameter)
at port 80
```
$ sudo tcpdump -i en0 -nn -s0 -l tcp port 80
```

tcpdump on en0 interface print each/All (ascii) packet
with no host or port resolution
unlimited packet and line buffered
tcp protocol only (can be udp or proto parameter)
at port 80
```
$ sudo tcpdump -i en0 -A -nn -s0 -l tcp port 80
```

tcpdump on en0 interface print each/All (ascii) packet
with no host or port resolution
unlimited packet and line buffered
tcp protocol only (can be udp or proto parameter)
at port 80 only for hosts
```
$ sudo tcpdump -i en0 -A -nn -s0 -l tcp port 80 host xx.xx.xx.xx
```

tcpdump on en0 interface print each/All (ascii) packet
with no host or port resolution
unlimited packet and line buffered
tcp protocol only (can be udp or proto parameter)
at port 80 write to wireshark compatible binary file
```
$ sudo tcpdump -i en0 -A -nn -s0 -l tcp port 80 -w packetcapture.pcap
```

capture password ignore case in egrep and 5 lines before
```
sudo tcpdump port http or port ftp or port smtp or port imap or port pop3 or port telnet -l -A | egrep -i -B5 'pass=|pwd=|log=|login=|user=|username=|pw=|passw=|passwd=|password=|pass:|user:|username:|password:|login:|pass |user '
```


ssh-keygen -t rsa -b 4096


client --> resolver ---> root servers
                    ----> TLDs (verisign)
                    ----> authority
