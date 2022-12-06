
```
javac SocketApp.java
java SocketApp server 12000 cookie-file.txt
java SocketApp client localhost 12000

```

For Threaded version
```
// from terminal 0
java SocketApp thread.server 12000 hello.txt

// from terminal 1
java SocketApp client localhost 12000

// from terminal 2
java SocketApp client localhost 12000
```
