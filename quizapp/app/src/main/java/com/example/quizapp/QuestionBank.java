package com.example.quizapp;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestionBank {
    public static ArrayList<Question> getQuestionsForSubject(String subject) {
        ArrayList<Question> questions = new ArrayList<>();
        switch (subject) {
            case "Hindi":
                questions.add(new Question("भारत की राजधानी क्या है?", new String[]{"मुंबई", "दिल्ली", "चेन्नई", "कोलकाता"}, 1));
                questions.add(new Question("'पुस्तक' शब्द का पर्यायवाची?", new String[]{"किताब", "कागज", "पेन", "लिखावट"}, 0));
                questions.add(new Question("निम्नलिखित में से क्रिया कौन सी है?", new String[]{"खेलना", "खेल", "खिलाड़ी", "खेलकूद"}, 0));
                questions.add(new Question("‘नील’ किस प्रकार का शब्द है?", new String[]{"संज्ञा", "क्रिया", "विशेषण", "क्रिया विशेषण"}, 2));
                questions.add(new Question("‘अंधकार’ का विलोम शब्द क्या है?", new String[]{"रात्रि", "प्रकाश", "अंधा", "तारा"}, 1));
                break;

            case "English":
                questions.add(new Question("Choose the synonym of 'Happy'", new String[]{"Sad", "Joyful", "Angry", "Tired"}, 1));
                questions.add(new Question("Opposite of 'Victory' is?", new String[]{"Win", "Triumph", "Defeat", "Honor"}, 2));
                questions.add(new Question("Which is a verb?", new String[]{"Run", "Dog", "Green", "Sky"}, 0));
                questions.add(new Question("What is the plural of 'Mouse'?", new String[]{"Mouses", "Mouse", "Mice", "Mices"}, 2));
                questions.add(new Question("‘He runs fast.’ – 'Fast' is?", new String[]{"Verb", "Adjective", "Adverb", "Noun"}, 2));
                break;

            case "Physics":
                questions.add(new Question("Unit of force is?", new String[]{"Joule", "Pascal", "Newton", "Watt"}, 2));
                questions.add(new Question("What is the speed of light?", new String[]{"3x10^8 m/s", "5x10^6 m/s", "7x10^9 m/s", "1x10^5 m/s"}, 0));
                questions.add(new Question("Who discovered gravity?", new String[]{"Einstein", "Newton", "Tesla", "Faraday"}, 1));
                questions.add(new Question("SI unit of energy?", new String[]{"Watt", "Joule", "Newton", "Ohm"}, 1));
                questions.add(new Question("Light travels in?", new String[]{"Straight line", "Curve", "Zig-zag", "Spiral"}, 0));
                break;

            case "Maths":
                questions.add(new Question("5 + 7 = ?", new String[]{"10", "12", "13", "15"}, 1));
                questions.add(new Question("Square of 9?", new String[]{"81", "72", "99", "100"}, 0));
                questions.add(new Question("10% of 200?", new String[]{"10", "20", "30", "40"}, 1));
                questions.add(new Question("What is 7 x 6?", new String[]{"42", "36", "48", "52"}, 0));
                questions.add(new Question("√64 = ?", new String[]{"6", "7", "8", "9"}, 2));
                break;

            case "Chemistry":
                questions.add(new Question("Water chemical formula?", new String[]{"H2O", "CO2", "O2", "HCl"}, 0));
                questions.add(new Question("NaCl is commonly known as?", new String[]{"Sugar", "Salt", "Chlorine", "Acid"}, 1));
                questions.add(new Question("Atomic number of Carbon?", new String[]{"4", "6", "8", "12"}, 1));
                questions.add(new Question("Acids taste?", new String[]{"Sweet", "Bitter", "Sour", "Salty"}, 2));
                questions.add(new Question("Gas used for respiration?", new String[]{"CO2", "N2", "H2", "O2"}, 3));
                break;
        }
        return questions;
    }
}
