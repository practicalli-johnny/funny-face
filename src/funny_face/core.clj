(ns funny-face.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET PUT]]
            [compojure.route :refer [not-found]]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]))

(defn welcome
  "A ring handler to respond with a simple welcome message"
  [request]
  {:status 200
   :body "<h1>Webservice placeholder</h1>"
   :headers {}})

(defn get-face
  "Returns a random face"
  [request]
  {:status 200
   :body "<img src=\"face.png\">"
   :headers {}}
  )


(defroutes app
  (GET "/" [] welcome)
  (GET "/face" [] get-face)
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
