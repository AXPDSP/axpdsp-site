(ns axpdsp-site.data
  (:require [reagent.core :as r]
            [clojure-sheets.core :as sheets]
            [clojure-sheets.key-fns :as sheets.key-fns]
            [clojure.core.async :as a]
            [clojure.string :as str]))

(def brothers (r/atom nil))
(def rush-events (r/atom nil))

(defn sheets-list->set [s]
  (when s
    (into []
          (map str/trim)
          (str/split s #","))))

(defn has-position? [position {:keys [positions]}]
  ((set positions) position))

(defn with-positions [positions brothers]
  (into
   []
   (comp (dedupe)
         (keep (fn [position]
                 (first (filter (partial has-position? position)
                                (sort-by :timestamp (comp - compare) brothers))))))
   positions))

(defn true-positions
  ([brother] (true-positions @brothers brother))
  ([brothers {:keys [positions scroll]
              :as   brother}]
   (let [positions (zipmap positions (with-positions positions brothers))]
     (assoc brother :positions (into []
                                     (comp
                                      (filter (comp #{scroll} :scroll val))
                                      (map key))
                                     positions)))))

(a/go (let [brothers-res (sheets/sheet->map
                          "1m1Ne5-iynuYu9IOXeBHtIcrv6vEjjgTrYlXsBqf02ko"
                          {:key-fn sheets.key-fns/idiomatic-keyword
                           :page   "Website"})
            brothers-res (shuffle
                          (into []
                                (comp
                                 (map #(update % :positions sheets-list->set))
                                 (map #(update % :major sheets-list->set)))
                                (a/<! brothers-res)))]
        (reset! brothers (into []
                               (map (partial true-positions brothers-res))
                               brothers-res))))

(a/go (let [rush-res (sheets/sheet->map
                      "1El7AF_OReo2qZqSrskB6DAAkN-v6EHchO-pP8ch1xD8"
                      {:key-fn sheets.key-fns/idiomatic-keyword})]
        (reset! rush-events (a/<! rush-res))))
