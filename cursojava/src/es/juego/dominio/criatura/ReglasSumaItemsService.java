package es.juego.dominio.criatura;

import java.util.List;
import es.juego.dominio.item.Item;

final class ReglasSumaItemsService {

    int sumarPuntos(List<Item> items) {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            Item it = items.get(i);
            total += it.getPuntos();
        }
        return total;
    }
}
