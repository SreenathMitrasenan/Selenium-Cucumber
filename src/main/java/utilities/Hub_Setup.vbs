'Description 	: This set of code is used to set up hub in current machine automatically, default port used is 4444
'Designed by 	: Sreenath Mitrasenan
'Date 		  	: 01Jun2021

Dim WshShell, strCurDir,hostIP
Set WshShell = CreateObject("WScript.Shell")
strCurDir    = WshShell.CurrentDirectory

'Script for registering hub 
WshShell.run "cmd /K CD "&strCurDir&" & java -jar selenium-server-standalone.jar -port 4444 -role hub"
WshShell.Popup "Setting up Hub Machina", 5, "Hub Machine Set UP"
'//verify manually whether hub is registered or not by opening  http://localhost:4444
Set WshShell = Nothing



