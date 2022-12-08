package com.sebCzabak.fullstackProject.registration.token;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {
    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    private final ConfirmationTokenRepository confirmationTokenRepository;
    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }

}
