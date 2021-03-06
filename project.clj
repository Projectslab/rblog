(defproject rblog "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [lib-noir "0.7.9"]
                 [compojure "1.1.6"]
                 [ring-server "0.3.1"]
                 [selmer "0.5.5"] ; remove?
                 [hiccup "1.0.4"]
                 [com.taoensso/timbre "2.7.1"]
                 [com.postspectacular/rotor "0.1.0"]
                 [com.taoensso/tower "2.0.1"]
                 [markdown-clj "0.9.38"]
                 [environ "0.4.0"]]
  :aot :all
  :repl-options {:init-ns rblog.repl}
  :plugins [[lein-ring "0.8.8"]
            [lein-environ "0.4.0"]]
  :ring {:handler rblog.handler/app
         :init    rblog.handler/init
         :destroy rblog.handler/destroy
         :auto-reload? true
         :auto-refresh? true
         :nrepl {:start? true :port 5555}}
  :profiles
  {:production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.2.1"]]
         :env {:selmer-dev true}}}
  :min-lein-version "2.0.0")
