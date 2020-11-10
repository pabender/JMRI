###############################################################
#   Clears <File History> area before you save Panel XML file #
#   Gerald Wolfson   9/2017                                   #
###############################################################
import jmri

jmri.InstanceManager.getDefault(jmri.util.revhistory.FileHistory).purge(0)
print("The <File History> section has been cleared")
