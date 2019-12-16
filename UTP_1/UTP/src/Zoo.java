public class Zoo implements IAggregable<Zoo, String[]>, IDeeplyCloneable<Zoo>{

    private String[] _types_animals;

    public Zoo(String[] types_animals){
        _types_animals = types_animals;
    }

    public Zoo(){ }

    public String[] get_types_animals(){
        return _types_animals;
    }
    public String[] aggregate(String intermediateResult[]){

        if(intermediateResult == null ) {
            return _types_animals;
        }
        String[] totalAnimals = new String[_types_animals.length+intermediateResult.length];
        System.arraycopy(_types_animals, 0, totalAnimals, 0, _types_animals.length);
        System.arraycopy(intermediateResult, 0, totalAnimals, _types_animals.length, intermediateResult.length);
            return totalAnimals;
    }
    public Zoo deepClone(){
        Zoo animal = new Zoo();
        animal._types_animals = _types_animals;
        return animal;
    }




}
