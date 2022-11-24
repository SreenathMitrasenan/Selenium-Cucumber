REMOTE EXECUTION CONFIGURATION FOR SEPERATE MACHINES

Pre-Requisites 
	a. Latest selenium-server-standalone.jar should be placed in the same folder
	b. All browser drivers should be made available in the same folder structure
	c. NodeIpConfigs.txt should be present with the ip address of the node machine

1.Configure hub machine 
	a. Double click on Hub_Setup.vbs
	b. Default port for registering hub is 4444, can change if needed
	c. Verify manually whether hub is registered or not by opening  http://localhost:4444
	d. Remember current script Hub_Setup.vbs is made to handle the local/current machine as the hub server

2.Configure node machine
    a. The ip address for creating node machine should be entered in NodeIPConfigs.txt
    b. Double click on Node_Setup.vbs 
    c. Verify whether node is registered to hub or not by opening http://{hub ip address}:4444
    d. Current script registers node port as 5555, can change if needed
    
REMOTE EXECUTION CONFIGURATION FOR SAME MACHINES

Description: Here the same machine will act as hub and node, hub uses port 4444 and node uses 5555, which can be changed by amending the script
HubNode_Setup.vbs

Steps to configure 
	a. Double click on  HubNode_Setup.vbs, node and hub will get configured.
	b. Verify node is registered to hub by checking the console

