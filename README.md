# GroupChatProject

This repo contains programs to implement an online chat server.

* ChatServer.java runs the server by listening to clients and handling connections
* ChatClient.java handles keyboard input from the client
* ChatClientHandler.java takes the client's message and sends to other clients
* ChatClientListener.java gets and displays messages from the server

In ChatUI,

* within src/my/chatui, Client.java is the GUI for the chat form
* the updated version where code from ChatClient.java is integrated is in new_branch
* to get to new_branch, git clone the master repo and then git checkout new_branch
