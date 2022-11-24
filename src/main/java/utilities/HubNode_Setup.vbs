'Description 	: This set of code is used to set up node and hub in same machine automatically
'Designed by 	: Sreenath Mitrasenan
'Date 		  	: 01Jun2021
'Hub port 		: 4444
'Node port 		: 5555

Dim WshShell, strCurDir,hostIP
Set WshShell = CreateObject("WScript.Shell")
strCurDir    = WshShell.CurrentDirectory

'Extract ip address of local machine
strQuery = "SELECT * FROM Win32_NetworkAdapterConfiguration WHERE MACAddress > ''"
Set objWMIService = GetObject( "winmgmts://./root/CIMV2" )
Set colItems      = objWMIService.ExecQuery( strQuery, "WQL", 48 )
For Each objItem In colItems
    If IsArray( objItem.IPAddress ) Then
        If UBound( objItem.IPAddress ) = 0 Then
            strIP = "IP Address: " & objItem.IPAddress(0)
        Else
            strIP = "IP Addresses: " & Join( objItem.IPAddress, "," )
        End If
    End If
Next
hostIP=Trim(Split(Split(strIP,",")(0),":")(1))
WshShell.Popup hostIP, 2, "Machine IP Address"
'WScript.Echo hostIP

'Script for registering hub 
WshShell.run "cmd /K CD "&strCurDir&" & java -jar selenium-server-standalone.jar -port 4444 -role hub"
WshShell.Popup "Setting up Hub Machina", 5, "Hub Machine Set UP"
'//verify manually whether hub is registered or not by opening  http://localhost:4444

'Script for registering node, this should execute in the node machine
WshShell.run "cmd /K CD "&strCurDir&" & java -jar selenium-server-standalone.jar -role node -hub http://"&hostIP&":4444/grid/register -port 5555"
WshShell.Popup "Setting up Node Machina", 3, "Node Machine Set UP"

Set WshShell = Nothing



