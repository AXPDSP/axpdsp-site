(ns axpdsp-site.utils
  (:require [clojure.string :as str]))

(defn fix-url-protocol [url]
  (when url
    (if (str/includes? url "://")
      url
      (str "https://" url))))
