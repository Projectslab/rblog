(ns rblog.views.layout
  (:require [clojure.string :as s]
            [ring.util.response :refer [content-type response]]
            [compojure.response :refer [Renderable]]
            [rblog.views.twtb :as twtb])
  (:use [hiccup core page element util form]))

(def layout-model
  {:app-title "Rblog"
   :navigation [["/" "Home" ]
                ["/about" "About"]]})


(defn layout [view-model & content]
  "content - seq of hiccup markup
  wf - workflow name :provider, :client, :anonymous"
  (html5
    [:head
     [:title (:app-title view-model)]
     (include-css "/assets/bootstrap/dist/css/bootstrap.min.css")
     (include-css "/css/app.css")
     (include-js "/assets/jquery/jquery.min.js")
     (include-js "/assets/bootstrap/dist/js/bootstrap.min.js")
     (include-js "/js/app.js")]
    [:body
     [:div.container
      (twtb/navigation
        (:app-title view-model)
        (twtb/navbar
          (for [lnk (:navigation view-model)]
            [:li (apply link-to lnk)])))
      content]]))


(defn about [& [vm]]
  [:div.jumbotron
   [:h1 "About us"]
   (link-to {:class "btn btn-success"} "/home"  "Read More")])

(defn home [& [vm]]
  [:div.jumbotron
   [:h1 "Welcome to rblog"]
   (link-to {:class "btn btn-success"} "/about"  "Read More")])

(defn render [template & [params]]
  (if-let [view (ns-resolve 'rblog.views.layout (symbol (name template)))]
    (layout layout-model
            (view params))
    (layout layout-model (str "No template function for " template))))

