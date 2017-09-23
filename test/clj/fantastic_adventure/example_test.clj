(ns fantastic-adventure.example-test
  (:require [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.core.async :as async :refer [>! <! >!! <!! go chan
                                                  buffer close! alts!!]]))

(deftest example-passing-test
  (is (= 1 1)))

(def sort-idempotent-prop
  (prop/for-all [v (gen/vector gen/int)]
                (= (sort v) (sort (sort v)))))

(tc/quick-check 100 sort-idempotent-prop)

(def prop-sorted-first-less-than-last
  (prop/for-all [v (gen/not-empty (gen/vector gen/int))]
                (let [s (sort v)]
                  (< (first s) (last v)))))

(tc/quick-check 100 prop-sorted-first-less-than-last)

(def prop-no-42
  (prop/for-all [v (gen/vector gen/int)]
                (not (some #{42} v))))

(tc/quick-check 100 prop-no-42)

(defspec first-element-is-min-after-sorting
  100
  (prop/for-all [v (gen/not-empty (gen/vector gen/int))]
                (= (apply min v)
                   (first (sort v)))))

(def warehouse-capacity 10)

(def warehouse-channel (chan warehouse-capacity))

(def stock-map {0 :shirt
                1 :pants
                2 :socks
                3 :shoes})
