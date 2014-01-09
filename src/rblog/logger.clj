(ns rblog.logger
  (:require
    [noir.util.middleware :as middleware]
    [taoensso.timbre :as timbre]
    [com.postspectacular.rotor :as rotor]))

(defn configure-logger! []
  (timbre/set-config!
    [:appenders :rotor]
    {:min-level :info
     :enabled? true
     :async? false ; should be always false for rotor
     :max-message-per-msecs nil
     :fn rotor/append})

  (timbre/set-config!
    [:shared-appender-config :rotor]
    {:path "rblog.log" :max-size (* 512 1024) :backlog 10}))

(defn info [mess] (timbre/info mess))
