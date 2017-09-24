(ns fantastic-adventure.core-test
  (:require-macros [cljs.test :refer (is deftest testing)]
                   [clojure.test.check.clojure-test :refer [defspec]])
  (:require [cljs.test]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop :include-macros true]))

(deftest example-passing-test
  (is (= 1 1)))

(defspec sort-idempotent-prop
  100
  (prop/for-all [v (gen/vector gen/int)]
                (= (sort v) (sort (sort v)))))
