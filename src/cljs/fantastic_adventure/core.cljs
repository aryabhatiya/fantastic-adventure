(ns fantastic-adventure.core
  (:require [rum.core :as rum]))

(enable-console-print!)

(rum/defc greeting []
  [:h1 "helloworld"])

(defn render []
  (rum/mount (greeting) (. js/document (getElementById "app"))))
