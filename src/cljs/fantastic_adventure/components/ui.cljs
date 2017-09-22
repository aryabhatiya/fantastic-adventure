(ns fantastic-adventure.components.ui
  (:require [com.stuartsierra.component :as component]
            [fantastic-adventure.core :refer [render]]))

(defrecord UIComponent []
  component/Lifecycle
  (start [component]
    (render)
    component)
  (stop [component]
    component))

(defn new-ui-component []
  (map->UIComponent {}))
