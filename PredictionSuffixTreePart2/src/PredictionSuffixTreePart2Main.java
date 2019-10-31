
/*
 * c2017-2019 Courtney Brown 
 * 
 * Class: H
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer
 * 
 */

import processing.core.*;
import java.util.ArrayList;

import java.util.*; 

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

public class PredictionSuffixTreePart2Main extends PApplet {
	public static void main(String[] args) {
		PApplet.main("PredictionSuffixTreePart2Main"); 
	}
	
	MelodyPlayer player; //play a midi sequence
	MidiFileToNotes midiNotes; //read a midi file
	
	Tree<Character> newTree1 = new Tree();
	Tree<Character> newTree2 = new Tree();
	Tree<Character> newTree3 = new Tree();
	Tree<Integer> newTree4 = new Tree();
	
	//Iput Arrays
	Character[] list1 = {'a','b','r','a','c','a','d','a','b','r','a'};
	Character[] list2 = {'a','c','a','d','a','a','c','b','d','a'};
	Character[] list3 = {'a','b','c','c','c','d','a','a','d','c','d','a','a','b','c','a','d','a','d'};
	//Change to ArrayList
	ArrayList<Character> test1 = new ArrayList(Arrays.asList(list1));
	ArrayList<Character> test2 = new ArrayList(Arrays.asList(list2));
	ArrayList<Character> test3 = new ArrayList(Arrays.asList(list3));
	//Mary Had a Little Lamb
	ArrayList<Integer> notes;
	
	public void settings() {
		size(400, 300);
	}

	public void setup() {
		fill(120, 50, 240);
		
		//Mary Had a Little Lamb
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
		midiNotes = new MidiFileToNotes(filePath); 
		notes = midiNotes.getPitchArray();
	}
	
	public void draw() {
		text("Press 1 for Sequence " + test1, 10, 20);
		text("Press 2 for Sequence " + test2, 10, 40);
		text("Press 3 for Sequence " + test3, 10, 60);
		text("Press 4 Mary had a Little Lamb", 10, 80);
	}
	
	public void keyPressed() {
		  if (key == '1') {
		    unitTest1();
		  }
		  if(key == '2') {
			  unitTest2();
		  }
		  if(key == '3' ){
			  unitTest3();
		  }
		  if(key == '4') {
			  unitTest4();
		  }
	}
	
	void unitTest1() {
		System.out.println("Test Sequence = " + test1);
		newTree1.train(test1);
		newTree1.print();
	}
	
	void unitTest2() {
		System.out.println("Test Sequence = " + test2);
		System.out.println("Hello");
		newTree2.train(test2);
		newTree2.print();
	}
	
	void unitTest3() {
		System.out.println("Test Sequence = " + test3);
		newTree3.train(test3);
		newTree3.print();
	}
	
	void unitTest4() {
		System.out.println("Mary Had a Little Lamb");
		newTree4.train(notes);
		newTree4.print();
	}
	
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	
}

