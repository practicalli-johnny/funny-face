(ns funny-face.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET PUT]]
            [compojure.route :refer [not-found]]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [ring.middleware.resource :refer :all]
            [clojure.java.io :as io]
            [quil.core :as q]))

;;;;;;;;;;;;;;;;;;;;;;;;
;; Quil fun


(defn setup []
  (q/smooth)
  (q/frame-rate 3)
  (q/background 200))

(defn draw []
  (q/stroke (q/random 255))
  (q/stroke-weight (q/random 10))
  (q/fill (q/random 255))

  (let [diam (q/random 100)
        x    (q/random (q/width))
        y    (q/random (q/height))]
    (q/ellipse x y diam diam))
  (q/save "quil-face.png"))

(q/defsketch example
  :title "Oh so many grey circles"
  :setup setup
  :draw draw
  :size [323 200]
  )

;;;;;;;;;;;;;;;;;;;;;;;;
;; Ring & Compojure stuff

(defn welcome
  "A ring handler to respond with a simple welcome message"
  [request]
  {:status 200
   :body "<h1>Webservice placeholder</h1>"
   :headers {}})

(defn get-face
  "Returns a random face"
  [request]
  (html5 {:lang "en"}
         [:head (include-js "myscript.js") (include-css "mystyle.css")]
         [:body
          [:div [:h1 {:class "info"} "This is Hiccup"]]
          [:div [:image "face.png"]]]))


#_(defn random-face [])


(defn ring-face
  [request]
  {:status 200
   :body (io/file "face.png")
   :headers {"Content-Type" "image/png"}})

(defn quil-face
  [request]
  {:status 200
   :body (io/file "quil-face.png")
   :headers {"Content-Type" "image/png"}})

(defroutes app
  (GET "/" [] welcome)
  (GET "/face" [] get-face)
  (GET "/ring-face" [] ring-face)
  (GET "/quil-face" [] quil-face)
  (not-found "<h1>This is not the page you are looking for</h1>
              <p>Sorry, the page you requested was not found!</p>"))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty app
     {:port (Integer. port-number)}))

(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
     {:port (Integer. port-number)}))











;; Reader macros
;; (list 1 2 3 4)
;; (quote  (1 2 3 4))
;; '(1 2 3 4)
#_(-> (str "fish")
    #_(str "bla"))

;;; (funtion
;;      blah)
