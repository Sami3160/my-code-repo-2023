import cv2
import pytesseract
from matplotlib import pyplot as plt


# image_path = "images\-notes.jpg"
# image = cv2.imread(image_path)
# image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

# gray_image=cv2.cvtColor(image_rgb, cv2.COLOR_BGR2GRAY)
# print("gray scale image")
# cv2_imshow("Gray Scale Image", gray_image)




# plt.figure(figsize=(10, 6))
# plt.imshow(image_rgb)
# plt.title("Original Image")
# plt.axis("off")
# plt.show()




def extractText(image_path):
    # image_path = "images\-notes.jpg"
    image = cv2.imread(image_path)
    image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    gray_image=cv2.cvtColor(image_rgb, cv2.COLOR_BGR2GRAY)
    extracted_text = pytesseract.image_to_string(image_rgb)

    return extracted_text
# print(" Extracted Text:\n")
# print(extracted_text)


