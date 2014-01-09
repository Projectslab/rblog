(ns rblog.views.twtb
  (:use [hiccup core page element util form]))

(defn navbar-right [& cnt]
  [:ul.nav.navbar-nav.navbar-right cnt])

(defn navbar [& cnt]
  [:ul.nav.navbar-nav cnt])

(defn navigation [brand & cnt]
  [:div.navbar.navbar.navbar-inverse.navbar-fixed-top.topnav
   {:role "navigation"}
   [:div.container
    [:div.navbar-header
     [:button.navbar-toggle
      {:type "button"  :data-toggle "collapse" :data-target ".navbar-collapse"}
      [:span.sr-only "Toggle navigation"]
      (take 3 (repeat #([:span.icon-bar])))
      ]
     [:a.navbar-brand {:href "/"} brand]]
    [:div.navbar-collapse.collapse cnt]
    ]])

(defn row [& cnt ]
  [:div.row cnt])

(defn cell [width & cnt ]
  [:div {:class (str "col-md-" width)} cnt])


(defmacro defcell [width]
  (let [cls (str "col-md-" width)
        fname (symbol (str "cell-" width))]
    `(defn ~fname [& cnt#]
       [:div {:class ~cls} cnt#]))) ;better call the cell function

(defcell 1)
(defcell 2)
(defcell 3)
(defcell 4)
(defcell 5)
(defcell 6)
(defcell 7)
(defcell 8)
(defcell 9)
(defcell 10)
(defcell 11)
(defcell 12)

(defmacro defbtn [m]
  (let [bname (str "btn-" (name m))
        fname (symbol bname)]
    `(defn ~fname
       ([lbl#] [:button.btn {:class ~bname} lbl#])
       ([href# lbl#] [:a.btn {:class ~bname :href href#} lbl#]))
    ))

(defbtn :default)
(defbtn :danger)
(defbtn :primary)
(defbtn :info)
(defbtn :success)

(defn row [& pairs]
  "(row 6 [:hiccup] 6 [:hiccup])"
  [:div.row
   (for [[w h] (partition 2 pairs)]
     [:div {:class (str "col-xs-" w)} h])])

