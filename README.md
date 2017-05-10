# GroupChatProject

This repo contains programs to implement an online chat server.

* ChatServer.java runs the server by listening to clients and handling connections
* ChatClient.java handles keyboard input from the client
* ChatClientHandler.java takes the client's message and sends to other clients
* ChatClientListener.java gets and displays messages from the server

# Instructions for Installing Necessary Components
* We developed our GUI in NetBeans, which you can download [here](https://netbeans.org/downloads/)

# Instructions to Run the Project
To run the server, be in the main directory
* compile using javac *.java
* execute using java ChatServer
To run the command line chat client, be in the main directory
* if you have already compiled, there is no need to repeat
* execute using java ChatClient
* you can open multiple command lines and instances of ChatClient
To run the GUI, you must have the server running. Then,
* open NetBeans
* once in NetBeans, open the project, ChatUI
* run by hitting the green triangle
