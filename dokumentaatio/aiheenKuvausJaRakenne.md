**Aihe**: Yksinkertainen yhden käyttäjän kassajärjestelmä (POS, Point-Of-Sale), jolla voi kirjata myyntiä.

**Käyttäjät**: Kauppias

**Toiminnot**:

- Uuden tilauksen alustaminen
![Alt text](/dokumentaatio/sequence_diagrams/product_to_cart.png "Sekvenssikaavio / Sequence Diagram")
- Tuotteen lisääminen avoimelle tilaukselle
![Alt text](/dokumentaatio/sequence_diagrams/create_payment.png "Sekvenssikaavio / Sequence Diagram")

**Luokkakaavio**:

![Alt text](/dokumentaatio/woopos_class_diagram.png "Luokkakaavio / Class Diagram")


**Rakennekuvaus**:

Ohjelman keskeinen osa on OrderController, joka huolehtii ostoskorin alustuksesta, uuden tilauksen luomisesta (ostoskorin sisällön pohjalta) ja maksun kirjaamisesta avoimelle tilaukselle. OrderController kuuntelee käyttöliittymän näppäinpainallus-eventtejä sekä ostoskorin ja tilauksen lähettämiä eventtejä (esim. kun ostoskorin sisältö muuttuu, kun tilaus kuittaantuu maksetuksi) ja välittää nämä eteenpäin käyttöliittymälle. WooPOS() on sovelluksen konteksti, joka alustaa kaikki tarvittavat komponentit (tietokanta/backend, controller, käyttöliittymä) ja jonka kautta eri komponentit saavat viitteet toisiinsa.
