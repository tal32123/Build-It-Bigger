package com.example;

public class JokeifyMe {
    int jokeArrayCount = 0;

    final static String[] OTHER_JOKE_ARRAY = new String[]{
            "Q.Whats the difference between a tractor and a giraffe? A.One has hydraulics the other has highbollocks.",
            "Q. What kind of band doesn't play music? A. A highbred.",
            "Q. If one is single and two is a couple and three is a crowd, what is four and five? A. 9 (5+4)",
            "Q. What do you get when you cross a parrot and a lion? A. I don't know, but when it talks you'd better listen.",
            "Q. Why do giraffes have long necks? A. Because they have smelly feet.",
            "Q. Why did the orange use suntan lotion? A. He started to peel.",
            "Q. Where does an elephant go when he wants to lie down? A. Anywhere he pleases.",
            "Q. What did the big chimney say to the little chimney? A. \"You are too young to smoke.\"",
            "Q. What did the fish say to the seashores? A. \"Can I ride on you seashorse?\"",
            "Q. Why did Cinderella get kicked off the baseball team? A. Because she ran away from the ball.",
            "Q. A man went to play golf for the day. He took his golf clubs and two pairs of pants. What were the extra pants for? A. In case he got a hole-in-one.",
            "Q. Why didn't the skeleton cross the road? A. Because it had no guts.",
            "Q. I have 3 heads, 5 legs, 7 arms and 444 fingers. What am I? A. A liar.",
            "Q. What do you get when you cross an elephant with a kangaroo? A. Holes all over Australia.",
            "Q. What goes ha, ha plonk? A. Someone laughing their head off.",
            "Q. What do you get when you cross a duck with cheese? A. Cheese and quackers.",
            "Q. What monster sits on the end of your finger? A. The bogie man.",
            "Q. What did the computer screen say to the keyboard after it went for a ride? A. That was a harddrive.",
            "Q. What is a pirate's favourite letter? A. R(Arrrrrggggh)",
            "Q. Why did the cow jump over the moon? A. Because the farmer had cold hands.",
            "Q. How do you make a tissue dance? A. Put a little boogie in it.",
            "Q: How do you get a man to stop biting his nails? A: Make him wear shoes.",
            "Q: Why do chicken coops have two doors? A: Because if it had four doors it's be a chicken sedan.",
            "Q: What is the difference between a tick and a lawyer? A: A tick falls off you when you die.",
            "Q: What's the definition of mixed emotions? A: When you see your mother-in-law backing off a cliff in your new car.",
            "Q: What do call a lawyer with an IQ of 50? A: Your Honor.",
            "Q: How do you know if a restaurant has a clown as a chef? A: When the food tastes funny",
            "Q: Why do Farts stink? A: So that Deaf people can enjoy them too.",
            "Q: Why did the Hedgehog cross the road? A: To see his Flat Mate.",
            "Q: What do you call a Fish without an eye? A: A 'Fsh'!",
            "Q: Why does it take 1 million sperm to fertilize one egg? A: They won't stop to ask directions.",
            "Q: What's the difference between Big Foot and an intelligent man? A: Big Foot's been spotted several times.",
            "Q: What do you call a handcuffed man? A: Trustworthy.",
            "Q: What did the fish say when he hit a concrete wall? A: \"Dam\".",
            "Q: Why is divorce so expensive? A: Because it's worth it.",
            "Q. What is black, white and red all over? A. A skunk with nappy rash.",
            "Q. Why did the man jump out of the window? A. He wanted to catch a butterfly.",
            "Q. Why did the monkey put a piece of steak on his head? A. He thought he was a griller.",
            "Q. What do you call a deer with no eyes? A. No eye deer.",
            "Q. What do you call a deer with no eyes and no legs? A. Still no eye deer.",
            "Q. Why was six afraid of seven? A. Because seven eight nine.",
            "Q. Why did the dinosaur walk across the road? A. Because chickens were not invented yet.",
            "Q. What has four wheels and flies? A. A rubbish truck.",
            "Q. What's brown and sticky? A. A stick.",
            "Q. When were vowels invented? A. When u and i were born.",
            "Q. What's orange and sounds like a parrot? A. A carrot.",
            "Q. What do you call a sheep with no head and legs? A. A fuzz ball.",
            "Q. What do you call a fairy that hasn't bathed in a year? A. Stinkerbell.",
            "Q. When is it a good time to eat a window? A. When it's jammed."
    };
    public String getJoke(){

        String joke;
        if(jokeArrayCount < OTHER_JOKE_ARRAY.length){
            joke = OTHER_JOKE_ARRAY[jokeArrayCount];
            jokeArrayCount++;
        }
        else{
            jokeArrayCount = 0;
            joke = OTHER_JOKE_ARRAY[jokeArrayCount];
        }

        return joke;
    }
    public static String[] getOTHER_JOKE_ARRAY(){
        return OTHER_JOKE_ARRAY;
    }
}
