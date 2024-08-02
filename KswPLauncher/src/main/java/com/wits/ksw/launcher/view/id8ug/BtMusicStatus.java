package com.wits.ksw.launcher.view.id8ug;

public class BtMusicStatus {
    private String album;
    private String artist;
    private int duration;
    private boolean isOtherControlling;
    private boolean isPauseByVoice;
    private boolean isPlayPauseControlling;
    private boolean isPlaying;
    private String name;
    private int pos;
    private int total;

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist2) {
        this.artist = artist2;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album2) {
        this.album = album2;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration2) {
        this.duration = duration2;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int pos2) {
        this.pos = pos2;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total2) {
        this.total = total2;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setPlaying(boolean playing) {
        this.isPlaying = playing;
    }

    public boolean isPauseByVoice() {
        return this.isPauseByVoice;
    }

    public void setPauseByVoice(boolean pauseByVoice) {
        this.isPauseByVoice = pauseByVoice;
    }

    public boolean isPlayPauseControlling() {
        return this.isPlayPauseControlling;
    }

    public void setPlayPauseControlling(boolean playPauseControlling) {
        this.isPlayPauseControlling = playPauseControlling;
    }

    public boolean isOtherControlling() {
        return this.isOtherControlling;
    }

    public void setOtherControlling(boolean otherControlling) {
        this.isOtherControlling = otherControlling;
    }

    public String toString() {
        return "MusicStatus{name='" + this.name + '\'' + ", artist='" + this.artist + '\'' + ", album='" + this.album + '\'' + ", duration=" + this.duration + ", pos=" + this.pos + ", total=" + this.total + ", isPlaying=" + this.isPlaying + ", isPlayPauseControlling=" + this.isPlayPauseControlling + ", isOtherControlling=" + this.isOtherControlling + '}';
    }
}
