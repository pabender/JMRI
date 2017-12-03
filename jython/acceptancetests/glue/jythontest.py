import java
import jmri
from jmri.jmrix.internal import InternalAdapter
from jmri.jmrit.automat import AbstractAutomaton
from jmri.util import JUnitUtil

class Wrapper(jmri.jmrit.automat.AbstractAutomaton) :
    
    def init(self):
        #init called once
        return
    
    def handle(self):
        return 1
    
@Before()
def beforesteps(self):
   jmri.util.JUnitUtil.initDebugThrottleManager()
   self.a = Wrapper()
   self.a.start()

@After()
def aftersteps(self):
   self.a.stop
 
@Given('^the InstanceManager is started$')
def start_instanceManager(self):
   return

@When('^I ask for a throttle$')
def i_ask_for_a_throttle(self):
   self.throttle = self.a.getThrottle(14, False)  # short address 14

@Then('^I can control the throttle$')
def i_can_control_the_throttle(self):
   self.throttle.setSpeedSetting(0.5)
   if(self.throttle.getSpeedSetting() != 0.5):
      raise(AssertionException("Speed not set"))

