'Description 	: This set of code is used to set up and register the node to hub machine automatically,hub machines ip address should be entered in the 'NodeIPConfigs.txt
'Designed by 	: Sreenath Mitrasenan
'Date 		  	: 01Jun2021
'Hub port 		: 4444
'Node port 		: 5555
Dim WshShell, strCurDir,hostIP
Set WshShell = CreateObject("WScript.Shell")
strCurDir    = WshShell.CurrentDirectory

'Extract ip address of hub machine from NodeIPConfigs.txt
Set objFileToRead = CreateObject("Scripting.FileSystemObject").OpenTextFile(strCurDir&"\NodeIPConfigs.txt",1)
strFileText = Trim(objFileToRead.ReadAll())
objFileToRead.Close
Set objFileToRead = Nothing

hubIP= strFileText
WshShell.Popup hubIP, 2, "Hub Machine IP Address"

'//verify whether node is registered to hub or not by opening http://{hub ip address}:4444 , eg. http://192.168.1.164:4444 

'Script for registering node, this should execute in the node machine,  remember if there are multiple node machines, assign unique port number for every one registered to the hub

WshShell.run "cmd /K CD "&strCurDir&" & java -jar selenium-server-standalone.jar -role node -hub http://"&hubIP&":4444/grid/register -port 5555"
WshShell.Popup "Setting up Node Machina", 3, "Node Machine Set UP"

Set WshShell = Nothing
