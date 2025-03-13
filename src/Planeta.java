import java.util.Set;

public class Planeta extends CuerpoCeleste{
    public Planeta(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        super(nombre, periodoOrbital, tipoCuerpo);
    }

    public boolean addSatelite(CuerpoCeleste satelite) {
        if (satelite.getTipoCuerpo().equals(TipoCuerpoCeleste.LUNA)) {
            satelites.add(satelite);
            return true;
        }
        return false;
    }

    @Override
    public Set<CuerpoCeleste> getSatelites() {
        return super.getSatelites();
    }
}
