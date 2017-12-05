Feature: Python 

Background:
   Given the InstanceManager is started

Scenario: PythonTentaxCheck 
   When I ask for a throttle
   Then I can control the throttle
