public class Horses implements IAggregable<Horses, Integer>, IDeeplyCloneable<Horses> {

    private Integer _horse;

    public Horses(){
    }

    public Horses(Integer horse ) {
        _horse = horse;
    }
    public Integer get_horse(){
        return _horse;
    }


    public Integer aggregate(Integer intermediateResult){
        if(intermediateResult == null){
            return _horse;
        }else{
           return _horse + intermediateResult;
        }
    }
    public Horses deepClone() {
        Horses horses = new Horses();
        return horses;
    }
}
