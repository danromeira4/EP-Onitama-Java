package ep.jogo.onitama.entities;

public enum CardInformation {
  TIGER("TIGER"),
  DRAGON("DRAGON"),
  FROG("FROG"),
  RABBIT("RABBIT"),
  CRAB("CRAB"),
  ELEPHANT("ELEPHANT"),
  GOOSE("GOOSE"),
  ROOSTER("ROOSTER");

  private String name;

  CardInformation(String name){
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
