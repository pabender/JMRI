import jarray
import jmri
import com.digi.xbee

class ProtoThrottleListener(com.digi.xbee.api.listeners.IDataReceiveListener):
   
   def dataReceived(self,message):
      print "data: ",message.toString()

class ProtoThrottleDriver(jmri.jmrit.automat.AbstractAutomaton):
   # ctor starts up the serial port
   def __init__(self) :
      
      # find the XBee Module
      self.cm = jmri.InstanceManager.getDefault(jmri.jmrix.ieee802154.xbee.XBeeConnectionMemo)
      self.tc = self.cm.getTrafficController()
      self.Xbee = self.tc.getXBee()
      self.Xbee.addDataListener(ProtoThrottleListener())      

      print "Port opened OK"
      return
   
   def init(self) :
      return
   
   def handle(self) :
      data = self.Xbee.readData(100)
      if data is not None:
         print "rcv ",data.getDataString()
      return 1

# end of class definition

a = ProtoThrottleDriver()
#a.start();
print "End of Script"
