(ns rblog.routes.home
  (:use compojure.core)
  (:require [rblog.views.layout :as layout]
            [rblog.util :as util]))

(defn home-page []
  (layout/render :home)) ; {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render :about))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
