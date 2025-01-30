import { test, expect } from '@playwright/test';

test('login test', async ({ page }) => {
  await page.goto('http://localhost:5173/cLogin');
  await expect(page).toHaveURL('http://localhost:5173/cLogin');

  const usernameField = page.locator('[id="username"]');
  await expect(usernameField).toBeVisible();
  await expect(usernameField).toBeEnabled();

  const passwordField = page.locator('[name = "password"]');
  await expect(passwordField).toBeVisible();
  await expect(passwordField).toBeEnabled();

  const loginButton = page.locator('[name = "submit"]');
  await expect(loginButton).toBeVisible();
  await expect(loginButton).toBeEnabled();

  //Incorrect user name, incorrect password 
  await usernameField.fill('testuser');
  await passwordField.fill('testPassword');
  await loginButton.click();
  await page.waitForTimeout(1000);
  await page.screenshot({ path: './tests_sceenshots/icUNicPW.png' });
  await page.getByRole('button', { name: 'OK' }).click();
  await usernameField.clear();
  await passwordField.clear();

  //correct user name inorrect password
  await usernameField.fill('inventory');
  await passwordField.fill('testPassword');
  await loginButton.click();
  await page.waitForTimeout(1000);
  await page.screenshot({ path: './tests_sceenshots/cUNicPW.png' });
  await page.getByRole('button',{name: 'OK'}).click();
  await usernameField.clear();
  await passwordField.clear();

  //incorrect username correct password
  await usernameField.fill('sdcfsdcs');
  await passwordField.fill('inventory123');
  await loginButton.click();
  await page.waitForTimeout(1000);
  await page.screenshot({ path: './tests_sceenshots/icUNcPW.png' });
  await page.getByRole('button',{name: 'OK'}).click();
  await usernameField.clear();
  await passwordField.clear();

  //correct username correct password
  await usernameField.fill('inventory');
  await passwordField.fill('inventory123');
  await loginButton.click();
  await page.waitForTimeout(1000);
  await page.screenshot({ path: './tests_sceenshots/cUNcPW.png' });
  
});
