# tests that imports work

# manipulate the path to avoid copying test scripts into jython folder
import jmri
import jmri.util
import sys
sys.path.append(jmri.util.FileUtil.getAbsoluteFilename('program:src/test/java/jmri/script/import'))

# the import we are testing
import imported

memories.provide('result').setValue(imported.getFoo())
