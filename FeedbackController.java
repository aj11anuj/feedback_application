package com.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Map to the HTML form
    @RequestMapping("/")
    public String showForm() {
        return "index.html"; // This corresponds to the index.html file
    }

    // Handle form submission
    @PostMapping("/submitFeedback")
    public String submitFeedback(@ModelAttribute Feedback feedback) {
        feedbackRepository.save(feedback); // Save feedback data to the database
        return "redirect:/?success"; // Redirect to the form with a success message
    }
}
