#OOP Zadanie
##WoodFiiT
###Autor: Adam Tomčala

---
Môj projekt je zameraný na tvorbu aplikácie, ktorá bude slúžiť
na objednanie si dreveného nábytku, ktorý bude **vyrobený** na mieru.


Aplikáciu vytváram v IDE **InteliiJ IDEA Ultimate**.  
Pracujem s knižnicou **JavaFX** a dizajn som navrhoval v **SceneBuilder**-i.
---
###Informácie o projekte:  
Hlavná trieda je trieda Main.  
Dedenie som použil napríklad v triede Furniture a od tejto triedy dedia triedy,
Bed, Chair, Table a Wardrobe.  
Agregáciu používam napríklad v triede Customer, kde používam triedu ShoppingCart.  
Polymorfizmus využívam v triede ShoppingCart v metóde addToCart, pretože do tejto
funkcie posielam rôzne druhy nábytku a rôzne druhy dreva.    

Po zapnutí aplikácie sa zobrazí obrazovka, kde sa môžete prihlásiť ako admin alebo ako
zákazník. Po pokračovaní ako zákazník sa zobrazí menu produktov. Po stlačení tlačidla kúpiť
sa produkt pridá do nákupného košíka. Pre ukončenie nákupu, kliknete na tlačidlo košík a
vypnité svoje udáje. Následne, ak sa prihlásite ako admin uvidíte všetky objednávky, ktoré
boli vytvorené počas behu programu.