(ns fantastic-adventure.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [fantastic-adventure.core-test]
   [fantastic-adventure.common-test]))

(enable-console-print!)

(doo-tests 'fantastic-adventure.core-test
           'fantastic-adventure.common-test)
