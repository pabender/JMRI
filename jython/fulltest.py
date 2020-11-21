execfile("jython/test/ReporterFormatterTest.py")
m = ReporterFormatter()
m.start("LR146", "IM146")
test3enter()
print 'value: ' + memories.getMemory('IM146').value
#if (not memories.getMemory('IM146').value == '3 ') : raise AssertionError('IM146 value incorrect: \"'+memories.getMemory('IM146').value+"\"")
#test257enter()
m.stop()