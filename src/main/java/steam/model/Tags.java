
package steam.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Action",
    "Indie",
    "Great Soundtrack",
    "Music",
    "Shoot 'Em Up",
    "Fast-Paced",
    "Score Attack",
    "Bullet Hell",
    "Short",
    "Replay Value",
    "Arcade",
    "2D",
    "Singleplayer",
    "Difficult",
    "Platformer",
    "Pixel Graphics",
    "GameMaker",
    "Retro",
    "Casual",
    "Controller"
})
public class Tags {

    @JsonProperty("Action")
    private Integer action;
    @JsonProperty("Indie")
    private Integer indie;
    @JsonProperty("Great Soundtrack")
    private Integer greatSoundtrack;
    @JsonProperty("Music")
    private Integer music;
    @JsonProperty("Shoot 'Em Up")
    private Integer shootEmUp;
    @JsonProperty("Fast-Paced")
    private Integer fastPaced;
    @JsonProperty("Score Attack")
    private Integer scoreAttack;
    @JsonProperty("Bullet Hell")
    private Integer bulletHell;
    @JsonProperty("Short")
    private Integer _short;
    @JsonProperty("Replay Value")
    private Integer replayValue;
    @JsonProperty("Arcade")
    private Integer arcade;
    @JsonProperty("2D")
    private Integer _2D;
    @JsonProperty("Singleplayer")
    private Integer singleplayer;
    @JsonProperty("Difficult")
    private Integer difficult;
    @JsonProperty("Platformer")
    private Integer platformer;
    @JsonProperty("Pixel Graphics")
    private Integer pixelGraphics;
    @JsonProperty("GameMaker")
    private Integer gameMaker;
    @JsonProperty("Retro")
    private Integer retro;
    @JsonProperty("Casual")
    private Integer casual;
    @JsonProperty("Controller")
    private Integer controller;
    @JsonProperty("Free to Play")
    private Integer freeToPlay;
    @JsonProperty("MOBA")
    private Integer mOBA;
    @JsonProperty("Multiplayer")
    private Integer multiplayer;
    @JsonProperty("Strategy")
    private Integer strategy;
    @JsonProperty("e-sports")
    private Integer eSports;
    @JsonProperty("Team-Based")
    private Integer teamBased;
    @JsonProperty("Competitive")
    private Integer competitive;

    @JsonProperty("Online Co-Op")
    private Integer onlineCoOp;
    @JsonProperty("PvP")
    private Integer pvP;

    @JsonProperty("Co-op")
    private Integer coOp;
    @JsonProperty("RTS")
    private Integer rTS;
    @JsonProperty("Tower Defense")
    private Integer towerDefense;
    @JsonProperty("Fantasy")
    private Integer fantasy;
    @JsonProperty("RPG")
    private Integer rPG;
    @JsonProperty("Character Customization")
    private Integer characterCustomization;

    @JsonProperty("Action RPG")
    private Integer actionRPG;
    @JsonProperty("Simulation")
    private Integer simulation;
    
    @JsonProperty("FPS")
    private Integer fPS;
    @JsonProperty("Shooter")
    private Integer shooter;
    @JsonProperty("Tactical")
    private Integer tactical;
    @JsonProperty("First-Person")
    private Integer firstPerson;
    @JsonProperty("Military")
    private Integer military;
    @JsonProperty("War")
    private Integer war;
    @JsonProperty("Trading")
    private Integer trading;
    @JsonProperty("Realistic")
    private Integer realistic;
    @JsonProperty("Moddable")
    private Integer moddable;
    
    @JsonProperty("Open World")
    private Integer openWorld;
    @JsonProperty("Automobile Sim")
    private Integer automobileSim;
    @JsonProperty("Third Person")
    private Integer thirdPerson;
    @JsonProperty("Crime")
    private Integer crime;
    @JsonProperty("Adventure")
    private Integer adventure;
    @JsonProperty("Mature")
    private Integer mature;
    @JsonProperty("Third-Person Shooter")
    private Integer thirdPersonShooter;
    @JsonProperty("Racing")
    private Integer racing;
    @JsonProperty("Atmospheric")
    private Integer atmospheric;
    @JsonProperty("Sandbox")
    private Integer sandbox;
    @JsonProperty("Funny")
    private Integer funny;
    @JsonProperty("Comedy")
    private Integer comedy;
    @JsonProperty("Masterpiece")
    private Integer masterpiece;
    
    @JsonProperty("Survival")
    private Integer survival;
    @JsonProperty("Battle Royale")
    private Integer battleRoyale;
    @JsonProperty("Early Access")
    private Integer earlyAccess;
    @JsonProperty("Stealth")
    private Integer stealth;
    
    @JsonProperty("Horror")
    private Integer horror;
    @JsonProperty("Survival Horror")
    private Integer survivalHorror;
    @JsonProperty("Gore")
    private Integer gore;
    @JsonProperty("Blood")
    private Integer blood;
    @JsonProperty("Violent")
    private Integer violent;
    @JsonProperty("Psychological Horror")
    private Integer psychologicalHorror;
    
    @JsonProperty("Hero Shooter")
    private Integer heroShooter;
    @JsonProperty("Destruction")
    private Integer destruction;
    @JsonProperty("Physics")
    private Integer physics;
    @JsonProperty("Massively Multiplayer")
    private Integer massivelyMultiplayer;
    
    @JsonProperty("Hack and Slash")
    private Integer hackAndSlash;
    @JsonProperty("Loot")
    private Integer loot;
    @JsonProperty("MMORPG")
    private Integer mMORPG;
    @JsonProperty("Dungeon Crawler")
    private Integer dungeonCrawler;
    @JsonProperty("Dark Fantasy")
    private Integer darkFantasy;
    @JsonProperty("PvE")
    private Integer pvE;
    @JsonProperty("Inventory Management")
    private Integer inventoryManagement;
    @JsonProperty("Fishing")
    private Integer fishing;
    
    @JsonProperty("Exploration")
    private Integer exploration;
    @JsonProperty("JRPG")
    private Integer jRPG;
    @JsonProperty("Souls-like")
    private Integer soulsLike;
    
    @JsonProperty("Ninja")
    private Integer ninja;
    @JsonProperty("Story Rich")
    private Integer storyRich;
    @JsonProperty("Assassin")
    private Integer assassin;
    @JsonProperty("Dark")
    private Integer dark;
    @JsonProperty("Rhythm")
    private Integer rhythm;
    
    @JsonProperty("Soccer")
    private Integer soccer;
    @JsonProperty("Sports")
    private Integer sports;
    @JsonProperty("Football")
    private Integer football;
    @JsonProperty("Local Multiplayer")
    private Integer localMultiplayer;
    @JsonProperty("Split Screen")
    private Integer splitScreen;
    @JsonProperty("Local Co-Op")
    private Integer localCoOp;
    @JsonProperty("4 Player Local")
    private Integer _4PlayerLocal;
    
    @JsonProperty("Automation")
    private Integer automation;
    @JsonProperty("Base-Building")
    private Integer baseBuilding;
    @JsonProperty("Resource Management")
    private Integer resourceManagement;
    @JsonProperty("Crafting")
    private Integer crafting;
    @JsonProperty("Management")
    private Integer management;
    @JsonProperty("Trains")
    private Integer trains;
    @JsonProperty("Sci-fi")
    private Integer sciFi;
    @JsonProperty("Aliens")
    private Integer aliens;
    
    @JsonProperty("Anime")
    private Integer anime;
    @JsonProperty("Magic")
    private Integer magic;
    @JsonProperty("Female Protagonist")
    private Integer femaleProtagonist;
    
    @JsonProperty("Metroidvania")
    private Integer metroidvania;
    @JsonProperty("Hand-drawn")
    private Integer handDrawn;
    @JsonProperty("Cute")
    private Integer cute;
    @JsonProperty("Multiple Endings")
    private Integer multipleEndings;
    @JsonProperty("Side Scroller")
    private Integer sideScroller;
    
    @JsonProperty("Zombies")
    private Integer zombies;
    
    @JsonProperty("Open World Survival Craft")
    private Integer openWorldSurvivalCraft;
    @JsonProperty("Building")
    private Integer building;
    @JsonProperty("Nudity")
    private Integer nudity;
    @JsonProperty("Post-apocalyptic")
    private Integer postApocalyptic;
    
    @JsonProperty("Turn-Based Strategy")
    private Integer turnBasedStrategy;
    @JsonProperty("Historical")
    private Integer historical;
    @JsonProperty("Turn-Based")
    private Integer turnBased;
    @JsonProperty("Grand Strategy")
    private Integer grandStrategy;
    @JsonProperty("4X")
    private Integer _4X;
    @JsonProperty("City Builder")
    private Integer cityBuilder;
    @JsonProperty("Hex Grid")
    private Integer hexGrid;
    
    @JsonProperty("Dragons")
    private Integer dragons;
    @JsonProperty("Medieval")
    private Integer medieval;
    @JsonProperty("Lore-Rich")
    private Integer loreRich;
    
    @JsonProperty("Cartoon")
    private Integer cartoon;
    @JsonProperty("Cartoony")
    private Integer cartoony;
    @JsonProperty("Colorful")
    private Integer colorful;
    
    @JsonProperty("VR")
    private Integer vR;
    @JsonProperty("Memes")
    private Integer memes;
    @JsonProperty("Sexual Content")
    private Integer sexualContent;
    

    @JsonProperty("Western")
    private Integer western;
    @JsonProperty("Beautiful")
    private Integer beautiful;
    
    @JsonProperty("Dark Comedy")
    private Integer darkComedy;
    @JsonProperty("Capitalism")
    private Integer capitalism;
    
    @JsonProperty("Parkour")
    private Integer parkour;
    @JsonProperty("Dystopian ")
    private Integer dystopian;
    @JsonProperty("Stylized")
    private Integer stylized;
    @JsonProperty("Futuristic")
    private Integer futuristic;
    @JsonProperty("Cyberpunk")
    private Integer cyberpunk;
    @JsonProperty("Puzzle")
    private Integer puzzle;
    @JsonProperty("Time Attack")
    private Integer timeAttack;
    @JsonProperty("Classic")
    private Integer classic;

    @JsonProperty("Action")
    public Integer getAction() {
        return action;
    }

    @JsonProperty("Action")
    public void setAction(Integer action) {
        this.action = action;
    }

    @JsonProperty("Indie")
    public Integer getIndie() {
        return indie;
    }

    @JsonProperty("Indie")
    public void setIndie(Integer indie) {
        this.indie = indie;
    }

    @JsonProperty("Great Soundtrack")
    public Integer getGreatSoundtrack() {
        return greatSoundtrack;
    }

    @JsonProperty("Great Soundtrack")
    public void setGreatSoundtrack(Integer greatSoundtrack) {
        this.greatSoundtrack = greatSoundtrack;
    }

    @JsonProperty("Music")
    public Integer getMusic() {
        return music;
    }

    @JsonProperty("Music")
    public void setMusic(Integer music) {
        this.music = music;
    }

    @JsonProperty("Shoot 'Em Up")
    public Integer getShootEmUp() {
        return shootEmUp;
    }

    @JsonProperty("Shoot 'Em Up")
    public void setShootEmUp(Integer shootEmUp) {
        this.shootEmUp = shootEmUp;
    }

    @JsonProperty("Fast-Paced")
    public Integer getFastPaced() {
        return fastPaced;
    }

    @JsonProperty("Fast-Paced")
    public void setFastPaced(Integer fastPaced) {
        this.fastPaced = fastPaced;
    }

    @JsonProperty("Score Attack")
    public Integer getScoreAttack() {
        return scoreAttack;
    }

    @JsonProperty("Score Attack")
    public void setScoreAttack(Integer scoreAttack) {
        this.scoreAttack = scoreAttack;
    }

    @JsonProperty("Bullet Hell")
    public Integer getBulletHell() {
        return bulletHell;
    }

    @JsonProperty("Bullet Hell")
    public void setBulletHell(Integer bulletHell) {
        this.bulletHell = bulletHell;
    }

    @JsonProperty("Short")
    public Integer getShort() {
        return _short;
    }

    @JsonProperty("Short")
    public void setShort(Integer _short) {
        this._short = _short;
    }

    @JsonProperty("Replay Value")
    public Integer getReplayValue() {
        return replayValue;
    }

    @JsonProperty("Replay Value")
    public void setReplayValue(Integer replayValue) {
        this.replayValue = replayValue;
    }

    @JsonProperty("Arcade")
    public Integer getArcade() {
        return arcade;
    }

    @JsonProperty("Arcade")
    public void setArcade(Integer arcade) {
        this.arcade = arcade;
    }

    @JsonProperty("2D")
    public Integer get2D() {
        return _2D;
    }

    @JsonProperty("2D")
    public void set2D(Integer _2D) {
        this._2D = _2D;
    }

    @JsonProperty("Singleplayer")
    public Integer getSingleplayer() {
        return singleplayer;
    }

    @JsonProperty("Singleplayer")
    public void setSingleplayer(Integer singleplayer) {
        this.singleplayer = singleplayer;
    }

    @JsonProperty("Difficult")
    public Integer getDifficult() {
        return difficult;
    }

    @JsonProperty("Difficult")
    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    @JsonProperty("Platformer")
    public Integer getPlatformer() {
        return platformer;
    }

    @JsonProperty("Platformer")
    public void setPlatformer(Integer platformer) {
        this.platformer = platformer;
    }

    @JsonProperty("Pixel Graphics")
    public Integer getPixelGraphics() {
        return pixelGraphics;
    }

    @JsonProperty("Pixel Graphics")
    public void setPixelGraphics(Integer pixelGraphics) {
        this.pixelGraphics = pixelGraphics;
    }

    @JsonProperty("GameMaker")
    public Integer getGameMaker() {
        return gameMaker;
    }

    @JsonProperty("GameMaker")
    public void setGameMaker(Integer gameMaker) {
        this.gameMaker = gameMaker;
    }

    @JsonProperty("Retro")
    public Integer getRetro() {
        return retro;
    }

    @JsonProperty("Retro")
    public void setRetro(Integer retro) {
        this.retro = retro;
    }

    @JsonProperty("Casual")
    public Integer getCasual() {
        return casual;
    }

    @JsonProperty("Casual")
    public void setCasual(Integer casual) {
        this.casual = casual;
    }

    @JsonProperty("Controller")
    public Integer getController() {
        return controller;
    }

    @JsonProperty("Controller")
    public void setController(Integer controller) {
        this.controller = controller;
    }

}
